package org.bupt.fedraft.state;


import com.google.protobuf.ByteString;
import io.grpc.stub.StreamObserver;
import org.bupt.fedraft.config.Configuration;
import org.bupt.fedraft.exception.LocalTrainException;
import org.bupt.fedraft.job.jobmanager.Follower;
import org.bupt.fedraft.rpc.manager.message.JobSubmitResponse;
import org.bupt.fedraft.rpc.trainer.message.ModelClass;
import org.bupt.fedraft.server.ManagerClient;
import org.bupt.fedraft.server.TrainerClient;
import org.bupt.fedraft.utils.NetworkUtils;
import org.bupt.fedraft.utils.VisitType;
import org.bupt.fedraft.utils.WriteReadObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 保存训练任务运行时状态，包括JobManager的角色，拓扑信息等
 * @author yzzer
 */
public class JobManager {

    private static final Logger logger = LoggerFactory.getLogger(JobManager.class);
    private static final int MIN_PORT = Configuration.getInt(Configuration.TRAINER_SERVER_PORT_MIN);
    private static final int MAX_PORT = Configuration.getInt(Configuration.TRAINER_SERVER_PORT_MAX);
    private static final int FAIL_TIMES = Configuration.getInt(Configuration.TRAINER_SERVER_FAIL_TIMES);

    public final int uuid;
    public final long sourceId;
    public final List<Long> participants;

    // trainer失败计数
    private final AtomicInteger failCount;
    public final int globalEpoch;
    private final ManagerState managerState;
    private ManagerClient sourceClient;
    private TrainerClient trainerClient;
    public final String datasetName;
    public final ModelClass modelClass;

    private Process trainerProcess;

    private final WriteReadObject<ArrayList<ByteString>> localModel = new WriteReadObject<>(new ArrayList<>());

    private final WriteReadObject<ArrayList<ByteString>> globalModel = new WriteReadObject<>(new ArrayList<>());
    private final WriteReadObject<JobManagerRaftSate> raftState;

    /**
     * 日志回复器
     */
    public StreamObserver<JobSubmitResponse> responseObserver;

    public JobManager(ManagerState managerState, int uuid, long sourceId, int globalEpoch,
                      List<Long> participants,
                      String datasetName,
                      ModelClass modelClass,
                      StreamObserver<JobSubmitResponse> responseObserver) {
        this.uuid = uuid;
        this.sourceId = sourceId;
        this.participants = participants;
        this.responseObserver = responseObserver;
        this.managerState = managerState;
        this.globalEpoch = globalEpoch;
        this.datasetName = datasetName;
        this.modelClass = modelClass;

        if (responseObserver == null) {
            sourceClient = managerState.getManagerClientPool().getClient(sourceId);
        }

        failCount = new AtomicInteger(Configuration.getInt(Configuration.TRAINER_SERVER_FAIL_TIMES));

        setupTrainer();

        JobManagerRaftSate jobRaftSate = new JobManagerRaftSate();
        jobRaftSate.setJob(new Follower(this, managerState));
        raftState = new WriteReadObject<>(jobRaftSate);
    }

    public JobManager(ManagerState managerState, int uuid, long sourceId, int globalEpoch,
                      String datasetName,
                      ModelClass modelClass,
                      List<Long> participants) {
        this(managerState, uuid, sourceId, globalEpoch, participants, datasetName, modelClass, null);
    }


    public WriteReadObject<ArrayList<ByteString>> getLocalModel() {
        return localModel;
    }

    public WriteReadObject<ArrayList<ByteString>> getGlobalModel() {
        return globalModel;
    }

    public WriteReadObject<JobManagerRaftSate> getRaftState() {
        return raftState;
    }


    public void addGlobalModelChunk(ByteString chunk) {
        getGlobalModel().visit(chunks -> {
            chunks.add(chunk);
        }, VisitType.WRITE);
    }

    public void clearGlobalModelChunk() {
        getGlobalModel().visit(chunks -> {
            chunks.clear();
        }, VisitType.WRITE);
    }

    private void setupTrainer() {

        int port = 0;
        do {
            port = MIN_PORT + (int) ((MAX_PORT - MIN_PORT) * Math.random());
        } while (!NetworkUtils.isPortAvailable(port));
        // 测试出一个可用的端口

        try {
            startTrainerProcess(port);

        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    /**
     * 启动Trainer进程
     *
     * @param port Trainer进程的端口号
     * @throws IOException 执行启动脚本时发生的异常
     */
    private void startTrainerProcess(int port) throws IOException {
        // 执行trainer启动脚本，要求Trainer在当前目录下
        String[] cmdArr = {"/bin/bash", "-c", "./bin/server.sh start " + port};
        Process process = Runtime.getRuntime().exec(cmdArr);
        BufferedReader logger = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(process.getInputStream()));

        // 进程意外终止
        process.onExit().thenRun(() -> {
            // 关闭通信
            trainerClient.close();
            trainerClient = null;

            // 训练进程终止
            if (failCount.get() >= FAIL_TIMES || managerState.getJobState(sourceId, uuid) != JobManager.this) {
                // 当前任务已经被关闭 或失败次数过多
                String log = "trainer process on port:" + port
                        + " exit with value=" + process.exitValue();
                JobManager.logger.warn(log);
                sendLog(log);
                managerState.deleteJobState(sourceId, uuid);
                return;
            }
            failCount.addAndGet(1);
            // 重启进程
            JobManager.logger.warn("retry to start trainer process");
            setupTrainer();
        });

        String successLine;

        while ((successLine = logger.readLine()) != null) {
            if (successLine.contains("service.server : INFO  trainer server start on port:")) {
                // 启动成功后建立客户端连接
                JobManager.this.trainerClient = new TrainerClient(this, managerState, port);

                JobManager.logger.info(successLine);
                sendLog(successLine);
                break;
            }
        }

        // 监听进程输出
        new Thread(() -> watchTrainerLog(logger)).start();
        new Thread(() -> watchTrainerLog(stdIn)).start();
    }

    /**
     * 监听Trainer日志输出
     *
     * @param reader 日志输入流
     */
    private void watchTrainerLog(BufferedReader reader) {
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                JobManager.logger.info(line);
                sendLog(line);
            }
        } catch (IOException e) {
            JobManager.logger.error(e.getMessage());
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                JobManager.logger.error(e.getMessage());
            }
        }
    }

    public void sendLog(String log) {
        sendLog(log, true);
    }

    public void sendLog(String log, boolean isBatch) {
        log = log + "\tfrom ID: " + managerState.getSelfNodeInfo().getNodeId();
        if (sourceClient != null) {
            sourceClient.appendLog(this, log, isBatch);
        } else if (responseObserver != null) {
            JobSubmitResponse response = JobSubmitResponse.newBuilder().setLogs(log).build();
            responseObserver.onNext(response);
        }
    }


    public TrainerClient getTrainerClient() {
        return trainerClient;
    }

    public ManagerClient getSourceClient() {
        return sourceClient;
    }

    /**
     * 初始化完成后的本地训练/使用之前的参数进行本地训练
     */
    public void localTrain() {
        // 关闭计时器防止训练过程中触发重新选举
        getRaftState().visit(raftSate -> raftSate.getJob().closeTimer(), VisitType.READ);

        getLocalModel().visit(modelChunkCache -> {
            modelChunkCache.clear();
            try {
                trainerClient.trainModel(modelChunkCache);
            } catch (LocalTrainException e) {
                logger.error(e.getMessage());
            }
        }, VisitType.WRITE);


        CopyOnWriteArrayList<ByteString> list = new CopyOnWriteArrayList<>();
        triggerModelCollect();
    }


    /**
     * TODO 完成本地训练后触发模型回收或leader选举
     */
    private void triggerModelCollect() {

    }


    public void close() {

        // 关闭客户端通信
        if (trainerClient != null) {
            trainerClient.close();
            trainerClient = null;
        }


        // 关闭训练进程
        if (trainerProcess != null) {
            trainerProcess.destroy();
            trainerProcess = null;
        }


        // 关闭和提交源的通信
        if (responseObserver != null) {
            JobSubmitResponse response = JobSubmitResponse.newBuilder()
                    .setLogs("Job Shutdown in submitter")
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            responseObserver = null;
        }
        logger.info("trainer with uuid:{} closed", uuid);
    }


}
