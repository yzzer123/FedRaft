package org.bupt.fedraft.state;


import com.google.protobuf.ByteString;
import io.grpc.stub.StreamObserver;
import org.bupt.fedraft.config.Configuration;
import org.bupt.fedraft.rpc.manager.message.JobSubmitResponse;
import org.bupt.fedraft.server.ManagerClient;
import org.bupt.fedraft.server.TrainerClient;
import org.bupt.fedraft.utils.NetworkUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 保存训练任务运行时状态，包括JobManager的角色，拓扑信息等
 */
public class JobManager {

    private static final Logger logger = LoggerFactory.getLogger(JobManager.class);
    private static final int MIN_PORT = Configuration.getInt(Configuration.TRAINER_SERVER_PORT_MIN);
    private static final int MAX_PORT = Configuration.getInt(Configuration.TRAINER_SERVER_PORT_MAX);
    private static final int FAIL_TIMES = Configuration.getInt(Configuration.TRAINER_SERVER_FAIL_TIMES);

    public final int uuid;
    public final long sourceId;
    public final List<Long> participants;
    public StreamObserver<JobSubmitResponse> responseObserver; // 日志回复器
    private final int globalEpoch;
    private final ManagerState managerState;
    private ManagerClient sourceClient;
    private final AtomicInteger failCount;  // trainer失败计数
    private TrainerClient trainerClient;
    private Process trainerProcess;
    public List<ByteString> model = new ArrayList<>(10);

    public JobManager(ManagerState managerState, int uuid, long sourceId, int globalEpoch, List<Long> participants, StreamObserver<JobSubmitResponse> responseObserver) {
        this.uuid = uuid;
        this.sourceId = sourceId;
        this.participants = participants;
        this.responseObserver = responseObserver;
        this.managerState = managerState;
        this.globalEpoch = globalEpoch;
        if (responseObserver == null) {
            sourceClient = managerState.getManagerClientPool().getClient(sourceId);
        }

        failCount = new AtomicInteger(Configuration.getInt(Configuration.TRAINER_SERVER_FAIL_TIMES));

        setupTrainer();
    }

    public JobManager(ManagerState managerState, int uuid, long sourceId, int globalEpoch, List<Long> participants) {
        this(managerState, uuid, sourceId, globalEpoch, participants, null);
    }


    private void setupTrainer() {

        int port = 0;
        do {
            port = MIN_PORT + (int) ((MAX_PORT - MIN_PORT) * Math.random());
        } while (!NetworkUtils.isPortAvailable(port));  // 测试出一个可用的端口

        try {
            startTrainerProcess(port);

        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }


    private void startTrainerProcess(int port) throws IOException {
        // 执行trainer启动脚本，要求Trainer在当前目录下
        String[] cmdArr = {"/bin/bash", "-c", "./bin/trainerCli.sh start " + port};
        Process process = Runtime.getRuntime().exec(cmdArr);
        BufferedReader logger = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(process.getInputStream()));

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

        new Thread(() -> watchTrainerLog(logger)).start();
        new Thread(() -> watchTrainerLog(stdIn)).start();
    }

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
//            logger.error("append log: " + log);
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
