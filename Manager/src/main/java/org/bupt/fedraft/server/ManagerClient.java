package org.bupt.fedraft.server;

import com.google.protobuf.ByteString;
import io.grpc.Context;
import io.grpc.stub.StreamObserver;
import org.bupt.fedraft.beans.NodeInfo;
import org.bupt.fedraft.beans.Tuple;
import org.bupt.fedraft.config.Configuration;
import org.bupt.fedraft.exception.LogAppendException;
import org.bupt.fedraft.job.manager.BaseJob;
import org.bupt.fedraft.rpc.jobmanager.message.*;
import org.bupt.fedraft.rpc.manager.message.*;
import org.bupt.fedraft.rpc.manager.service.JobManagerServiceGrpc;
import org.bupt.fedraft.rpc.manager.service.ManagerServiceGrpc;
import org.bupt.fedraft.rpc.trainer.message.TrainRequest;
import org.bupt.fedraft.state.JobManager;
import org.bupt.fedraft.state.ManagerState;
import org.bupt.fedraft.utils.DataWrapper;
import org.bupt.fedraft.utils.VisitType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yzzer
 */
public class ManagerClient extends Client {

    private static final Logger logger = LoggerFactory.getLogger(ManagerClient.class);

    private final ManagerServiceGrpc.ManagerServiceStub asyncManagerStub;
    private final JobManagerServiceGrpc.JobManagerServiceStub asyncJobManagerStub;
    private final int BUFFER_SIZE = Configuration.getInt(Configuration.TRAINER_SERVE_LOG_BATCH_SIZE);
    private List<String> logBuffer;

    public ManagerClient(ManagerState managerState, NodeInfo clientInfo) {
        super(managerState, clientInfo);
        this.asyncManagerStub = ManagerServiceGrpc.newStub(getChannel());
        this.asyncJobManagerStub = JobManagerServiceGrpc.newStub(getChannel());
    }

    public static void appendEntriesOnCluster(BaseJob job) {

        ManagerState managerState = job.getManagerState();

        AppendEntriesRequest.Builder builder = AppendEntriesRequest.newBuilder()
                .setLeaderId(managerState.getSelfNodeInfo().getNodeId());

        boolean[] isBroken = {false};

        managerState.updateRaftState(raftState -> {
            if (raftState.job != job) {
                isBroken[0] = true;
                return;
            }
            managerState.getTopology(topology -> {
                raftState.entryIndex++;  // 发送前统一增加日志索引
                builder.setTerm(raftState.term);
                builder.setEntryIndex(raftState.entryIndex);
                for (Tuple<Long, Integer> tuple : topology) {
                    builder.addNodeIds(tuple.getLeft());
                    builder.addDelay(tuple.getRight());
                }
            });
        });

        if (isBroken[0]) {
            // 如果当前job已经变更 就放弃发送
            return;
        }

        ClientPool<ManagerClient> pool = managerState.getManagerClientPool();

        AppendEntriesRequest request = builder.build();

        for (Long id : request.getNodeIdsList()) {
            managerState.getThreadPool().submit(() -> pool.getClient(id).appendEntries(request, job));
        }
    }

    public static int voteForOnCluster(BaseJob job) {
        ManagerState managerState = job.getManagerState();

        ManagerVoteRequest.Builder builder = ManagerVoteRequest.newBuilder()
                .setCandidateId(managerState.getSelfNodeInfo().getNodeId());

        List<Long> ids = new ArrayList<>();

        managerState.updateRaftState(raftState -> managerState.getTopology(topology -> {
            builder.setTerm(raftState.term);
            builder.setEntryIndex(raftState.entryIndex);
            for (Tuple<Long, Integer> tuple : topology) {
                ids.add(tuple.getLeft());
            }
        }));


        ClientPool<ManagerClient> pool = managerState.getManagerClientPool();

        ManagerVoteRequest request = builder.build();

        for (Long id : ids) {
            if (!id.equals(request.getCandidateId())) {
                managerState.getThreadPool().submit(() -> pool.getClient(id).voteFor(request, job));
            }
        }

        return ids.size();
    }

    public static StreamObserver<JobSubmitRequest> submitJobOnCluster(ManagerState managerState, int uuid, List<Long> cluster) {
        Tuple<StreamObserver<JobSubmitRequest>, Semaphore>[] observers = new Tuple[cluster.size() - 1];
        int i = 0;
        long selfId = managerState.getSelfNodeInfo().getNodeId();
        ClientPool<ManagerClient> pool = managerState.getManagerClientPool();
        AtomicInteger failCount = new AtomicInteger(0);


        for (long id : cluster) {
            if (id != selfId) {
                observers[i++] = new Tuple<>(pool.getClient(id).submitJob(selfId, uuid, failCount, managerState)
                        , new Semaphore(1, true));
            }
        }

        return new StreamObserver<>() {

            @Override
            public void onNext(JobSubmitRequest request) {
                synchronized (this) {
                    for (Tuple<StreamObserver<JobSubmitRequest>, Semaphore> observer : observers) {
                        try {
                            observer.getRight().acquire();  // 提前锁住，防止乱序发送
                        } catch (InterruptedException e) {
                            logger.error(e.getMessage());
                        }
                        managerState.getThreadPool().submit(() -> {
                            observer.getLeft().onNext(request);
                            observer.getRight().release();
                        });
                    }
                }
            }

            @Override
            public void onError(Throwable t) {
                synchronized (this) {
                    for (Tuple<StreamObserver<JobSubmitRequest>, Semaphore> observer : observers) {
                        managerState.getThreadPool().submit(() -> observer.getLeft().onError(t));
                    }
                }
            }

            @Override
            public void onCompleted() {
                synchronized (this) {
                    for (Tuple<StreamObserver<JobSubmitRequest>, Semaphore> observer : observers) {
                        managerState.getThreadPool().submit(() -> {
                            try {
                                observer.getRight().acquire();
                            } catch (InterruptedException e) {
                                logger.error(e.getMessage());
                            }
                            observer.getLeft().onCompleted();
                            observer.getRight().release();
                        });
                    }
                }
            }
        };
    }

    public void appendEntries(AppendEntriesRequest request, BaseJob job) {


        asyncManagerStub.withDeadlineAfter(2L * BaseJob.BASE_HEARTBEAT_TIMEOUT, TimeUnit.MILLISECONDS).appendEntries(request, new StreamObserver<>() {
            @Override
            public void onNext(AppendEntriesResponse response) {
                job.onAppendEntriesResponse(response.getTerm(), response.getDelay(), getClientInfo().getNodeId());
            }

            @Override
            public void onError(Throwable t) {

                job.getManagerState().updateTopology(getClientInfo().getNodeId(), 2000000);
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    public void voteFor(ManagerVoteRequest request, BaseJob job) {

        asyncManagerStub.voteFor(request, new StreamObserver<>() {
            @Override
            public void onNext(ManagerVoteResponse response) {
                job.onVoteResponse(response.getVoteGranted(), response.getTerm());
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {

            }
        });
    }

    public void shutdownJob(long sourceId, int uuid) {
        JobShutdownRequest request = JobShutdownRequest.newBuilder()
                .setSourceId(sourceId)
                .setUuid(uuid)
                .build();
        asyncManagerStub.jobShutdown(request, new StreamObserver<>() {
            @Override
            public void onNext(JobShutdownResponse response) {

            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {

            }
        });
    }

    public StreamObserver<JobSubmitRequest> submitJob(long sourceId, int uuid, AtomicInteger falseCount, ManagerState managerState) {

        return asyncManagerStub.withDeadlineAfter(Configuration.getInt(Configuration.MANAGER_JOB_SUBMIT_TIMEOUT), TimeUnit.MILLISECONDS)

                .jobSubmit(new StreamObserver<>() {
                    private void onFail() {
                        JobManager jobState = managerState.getJobState(sourceId, uuid);
                        int fails = falseCount.addAndGet(1);
                        if (jobState != null && fails >= ((jobState.participants.size() + 1) / 2)) {

                            // 发送失败消息
                            logger.error("fails in cluster >= 1/2, couldn't initialize job");
                            JobSubmitResponse failLog = JobSubmitResponse.newBuilder()
                                    .setLogs("fails in cluster >= 1/2, couldn't initialize job")
                                    .build();
                            JobSubmitResponse failResponse = JobSubmitResponse.newBuilder()
                                    .setSuccess(false)
                                    .build();

                            if (jobState.responseObserver != null) {
                                jobState.responseObserver.onNext(failLog);
                                jobState.responseObserver.onNext(failResponse);
                            }
                            managerState.deleteJobState(sourceId, uuid);
                        }
                    }

                    @Override
                    public void onNext(JobSubmitResponse response) {
                        if (response.hasSuccess() && !response.getSuccess()) {
                            logger.error("got a job submit failure!");
                            onFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        logger.error(t.getMessage());
                        onFail();
                    }

                    @Override
                    public void onCompleted() {

            }
        });
    }


    /**
     * 转发训练日志 默认采用批量发送方式
     *
     * @param jobManager 任务配置
     * @param log        日志内容
     */
    public void appendLog(JobManager jobManager, String log) {
        appendLog(jobManager, log, true);
    }

    public void appendLog(AppendJobLogRequest request) {
        asyncJobManagerStub.appendLog(request, new StreamObserver<>() {
            @Override
            public void onNext(AppendJobLogResponse value) {

            }

            @Override
            public void onError(Throwable t) {
                logger.error(t.getMessage());
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    /**
     * 转发训练日志
     *
     * @param jobManager 任务配置
     * @param log        日志内容
     * @param isBatch    是否批量发送
     */
    public void appendLog(JobManager jobManager, String log, boolean isBatch) {
        if (logBuffer == null) {
            logBuffer = new ArrayList<>(BUFFER_SIZE + 1);
        }
        logBuffer.add(log);
        if (logBuffer.size() >= BUFFER_SIZE || !isBatch) {
            // 当缓存累计或立即发送时就情况缓存并发送
            AppendJobLogRequest request = AppendJobLogRequest.newBuilder()
                    .setSourceId(jobManager.sourceId)
                    .setUuid(jobManager.uuid)
                    .addAllLogs(logBuffer)
                    .build();
            asyncJobManagerStub.appendLog(request, new StreamObserver<>() {
                @Override
                public void onNext(AppendJobLogResponse response) {

                }

                @Override
                public void onError(Throwable t) {
                    logger.error("append log error " + t.getMessage());
                }

                @Override
                public void onCompleted() {

                }
            });

            logBuffer.clear();
        }
    }


    /**
     * 发送模型给Leader
     * TODO 测试
     */
    public void pushModel(JobManager jobManager, List<ByteString> model){

        StreamObserver<JobPushModelRequest> sender =
                asyncJobManagerStub.pushModel(new StreamObserver<>() {
                    @Override
                    public void onNext(JobPushModelResponse response) {
                        logger.info("model pushing result: {}", response.getSuccess());
                    }

                    @Override
                    public void onError(Throwable t) {
                        logger.error("error happened in model pushing" + t.getMessage());
                    }

                    @Override
                    public void onCompleted() {
                    }
                });

        jobManager.getRaftState().visit(raftSate -> {

            // 发送本地模型索引
            sender.onNext(JobPushModelRequest.newBuilder()
                    .setModelInfo(JobPullModelRequest.newBuilder()
                                .setTerm(raftSate.term)
                                .setModelIndex(raftSate.localModelIndex)
                                .build())
                    .build());

            // 发送模型块
            for (ByteString chunk : model) {
                sender.onNext(JobPushModelRequest.newBuilder()
                            .setModelChunk(chunk)
                            .build());
            }
        }, VisitType.READ);

    }

    /**
     * 从Leader拉取模型
     * TODO 测试
     * @param  modelIndexForSync 用于向多个节点同时拉取模型时比较模型的索引
     */
    public void pullModel(@Nonnull JobManager jobManager, DataWrapper<Long> modelIndexForSync){
        JobPullModelRequest.Builder requestBuilder = JobPullModelRequest.newBuilder();

        jobManager.getRaftState().visit(raftSate -> {

            // 构造请求， 当receiver发现自己的全局模型索引比sender的大，就会返回自己更新的模型
            requestBuilder.setTerm(raftSate.term)
                    .setModelIndex(raftSate.globalModelIndex);
        }, VisitType.READ);

        Context.CancellableContext cancellableContext = Context.current().fork().withCancellation();

        // 避免cancel时影响其他的调用

        cancellableContext.run(() -> {
            asyncJobManagerStub.pullModel(requestBuilder.build(), new StreamObserver<>() {

                private final List<ByteString> modelCache = new ArrayList<>();
                private long receivedModelIndex = 0L;

                @Override
                public void onNext(JobPullModelResponse response) {
                    if (response.hasModelChunk()){
                        modelCache.add(response.getModelChunk());
                    }else {
                        receivedModelIndex = response.getModelIndex();

                        // 检查收到的模型索引是否是最大的
                        if (modelIndexForSync != null){
                            synchronized (modelIndexForSync){
                                if (modelIndexForSync.get() < receivedModelIndex){
                                    modelIndexForSync.set(receivedModelIndex);
                                }else{
                                    cancellableContext.cancel(new LogAppendException("invalid model index"));
                                    return;
                                }
                            } // end synchronized
                        } // end if
                    }

                    // 后续继续检查是否存在更大索引的模型被接受
                    if (modelIndexForSync != null && modelIndexForSync.get() > receivedModelIndex){
                        cancellableContext.cancel(new LogAppendException("invalid model index"));
                    }


                }

                @Override
                public void onError(Throwable t) {
                    logger.error("pull model error" + t.getMessage());
                }

                @Override
                public void onCompleted() {
                    // 判断接收到的模型的索引是否合法， 将模型追加到本地模型中
                    jobManager.getRaftState().visit(raftSate -> {
                        if (receivedModelIndex > raftSate.globalModelIndex){

                            // 启动训练
                            StreamObserver<TrainRequest> sender;
                            sender = jobManager.getTrainerClient().trainModel(cancellableContext);

                            // 添加模型
                            jobManager.clearGlobalModelChunk(sender);
                            for (ByteString chunk : modelCache) {
                                jobManager.addGlobalModelChunk(chunk);
                            }

                            raftSate.globalModelIndex = receivedModelIndex;

                            sender.onCompleted();
                        }
                    }, VisitType.WRITE);


                }
            });// end rpc call

        });

    }
}
