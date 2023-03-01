package org.bupt.fedraft.server;

import io.grpc.Context;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import org.bupt.fedraft.beans.Tuple;
import org.bupt.fedraft.config.Configuration;
import org.bupt.fedraft.rpc.jobmanager.message.JobShutdownRequest;
import org.bupt.fedraft.rpc.jobmanager.message.JobShutdownResponse;
import org.bupt.fedraft.rpc.manager.message.*;
import org.bupt.fedraft.rpc.manager.service.ManagerServiceGrpc;
import org.bupt.fedraft.rpc.trainer.message.InitModelRequest;
import org.bupt.fedraft.state.JobManager;
import org.bupt.fedraft.state.ManagerState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ManagerService extends ManagerServiceGrpc.ManagerServiceImplBase {
    private static final Logger logger = LoggerFactory.getLogger(ManagerService.class);

    private final ManagerState managerState;

    public ManagerService(ManagerState managerState) {
        this.managerState = managerState;
    }

    @Override
    public void appendEntries(AppendEntriesRequest request, StreamObserver<AppendEntriesResponse> responseObserver) {

        Tuple<Integer, Integer> tuple = new Tuple<>(0, 0);

        managerState.updateRaftState(raftState -> {
            Tuple<Integer, Integer> response = raftState.job.appendEntries(raftState,
                    request.getTerm(),
                    request.getLeaderId(),
                    request.getEntryIndex(),
                    request.getNodeIdsList(),
                    request.getDelayList());
            tuple.setLeft(response.getLeft());
            tuple.setRight(response.getRight());
        });

        AppendEntriesResponse response = AppendEntriesResponse.newBuilder()
                .setTerm(tuple.getLeft())
                .setDelay(tuple.getRight())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    @Override
    public void voteFor(ManagerVoteRequest request, StreamObserver<ManagerVoteResponse> responseObserver) {
        Tuple<Boolean, Integer> tuple = new Tuple<>(false, 0);

        managerState.updateRaftState(raftState -> {
            Tuple<Boolean, Integer> response = raftState.job.voteFor(raftState,
                    request.getTerm(),
                    request.getCandidateId(),
                    request.getEntryIndex());
            tuple.setLeft(response.getLeft());
            tuple.setRight(response.getRight());
        });

        ManagerVoteResponse voteResponse = ManagerVoteResponse.newBuilder()
                .setTerm(tuple.getRight())
                .setVoteGranted(tuple.getLeft())
                .build();

        responseObserver.onNext(voteResponse);
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<JobSubmitRequest> jobSubmit(StreamObserver<JobSubmitResponse> responseObserver) {

        final StreamObserver<JobSubmitResponse> copyObserver = responseObserver;

        return new StreamObserver<>() {

            final private StreamObserver<JobSubmitResponse> observer = copyObserver;

            private StreamObserver<JobSubmitRequest> clusterObserver;

            private StreamObserver<InitModelRequest> trainerObserver;

            private JobManager jobState;

            private void initLocalEnv(JobSubmitRequest request, boolean isSubmitter, Context context) {
                // 构建本地环境
                try {
                    // TODO 后续对windows做适配
                    String modelHome = Configuration.getString(Configuration.TRAINER_MODEL_HOME);
                    assert modelHome != null;
                    if (!modelHome.endsWith("/")) {
                        modelHome += "/";
                    }
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(
                            modelHome
                                    + request.getConf().getCodeFile().getFileName()));
                    bufferedWriter.write(request.getConf().getCodeFile().getCode());
                    bufferedWriter.close();
                    logger.info("write code file success!");
                } catch (IOException e) {
                    JobSubmitResponse logResponse = JobSubmitResponse.newBuilder()
                            .setLogs("code file write failed").build();
                    JobSubmitResponse statusResponse = JobSubmitResponse.newBuilder()
                            .setSuccess(false).build();

                    responseObserver.onNext(logResponse);
                    responseObserver.onNext(statusResponse);
                    responseObserver.onCompleted();
                    return;
                }

                // 初始化本地的job state
                Context jobContext = context.fork();

                final JobSubmitRequest finalRequest = request;
                jobContext.run(() -> jobState = new JobManager(managerState, finalRequest.getConf().getUuid(),
                        finalRequest.getConf().getSourceId(),
                        finalRequest.getConf().getGlobalEpoch(),
                        finalRequest.getConf().getParticipantsList(),
                        isSubmitter ? observer : null));


                managerState.addJobState(jobState);

                Context newContext = context.fork();

                newContext.run(() -> trainerObserver = jobState.getTrainerClient().initModel());
            }

            @Override
            public void onNext(JobSubmitRequest request) {
                logger.debug("received request size: {}", request.getSerializedSize());


                // 收到提交的任务初始化请求
                if (request.hasConf()) {

                    boolean isSubmitter = false;

                    if (request.getConf().getSourceId() == 0L) { // 从client发出的提交请求需要填入sourceId

                        // 构造转发请求，填入源ID
                        JobConfiguration.Builder jobConfBuilder = request.getConf().toBuilder()
                                .setSourceId(managerState.getSelfNodeInfo().getNodeId());

                        managerState.getTopology(tuples -> {
                            for (Tuple<Long, Integer> tuple : tuples) {
                                jobConfBuilder.addParticipants(tuple.getLeft());
                            }
                        });

                        JobConfiguration jobConf = jobConfBuilder.build();

                        request = request.toBuilder().setConf(jobConf).build();
                        isSubmitter = true;
                    }
                    // 收到来自source的提交请求 检查配置是否合法
                    if (managerState.getJobState(request.getConf().getSourceId(),
                            request.getConf().getUuid()) != null) {  // uuid不合法 无法创建
                        logger.warn("job conf is invalid, fail to load");

                        JobSubmitResponse logResponse = JobSubmitResponse.newBuilder()
                                .setLogs("uuid is invalid").build();
                        JobSubmitResponse statusResponse = JobSubmitResponse.newBuilder()
                                .setSuccess(false).build();

                        observer.onNext(logResponse);
                        observer.onNext(statusResponse);
                        observer.onCompleted();
                        return;
                    }
                    // 先构建本地环境
                    initLocalEnv(request, isSubmitter, Context.current());

                    // 初始化 observer
                    if (isSubmitter) {
                        Context newContext = Context.current().fork();
                        final JobSubmitRequest finalRequest = request;
                        newContext.run(() -> clusterObserver = ManagerClient.submitJobOnCluster(
                                managerState,
                                finalRequest.getConf().getUuid(),
                                finalRequest.getConf().getParticipantsList()));

                        // 在集群内创建任务
                        clusterObserver.onNext(request);
                    }
                }

                if (request.hasModelChunk()) {
                    if (jobState == null) { // 没有提前创建配置
                        logger.warn("model chunk arrived without job conf");
                        JobSubmitResponse failResponse = JobSubmitResponse.newBuilder()
                                .setSuccess(false).build();
                        observer.onNext(failResponse);
                        observer.onError(Status.PERMISSION_DENIED
                                .withDescription("model chunk arrived without job conf")
                                .asException());
                        return;
                    }
                    jobState.model.add(request.getModelChunk());

                    // 向trainer发送模型
                    if (clusterObserver != null) {
                        clusterObserver.onNext(request);
                    }

                    trainerObserver.onNext(InitModelRequest.newBuilder()
                            .setModelChunk(request.getModelChunk()).build());

                }
            }

            @Override
            public void onError(Throwable t) {
                // 传输过程发生错误
                observer.onError(t);
                if (clusterObserver != null) {
                    clusterObserver.onError(t);
                }
                if (trainerObserver != null) {
                    trainerObserver.onError(t);
                    managerState.deleteJobState(jobState.sourceId, jobState.uuid);
                }
            }

            @Override
            public void onCompleted() {
                JobManager existed = managerState.getJobState(jobState.sourceId, jobState.uuid);
                if (existed != null) {
                    // 当前manager保存了job state状态，说明启动成功
                    JobSubmitResponse response = JobSubmitResponse.newBuilder()
                            .setSuccess(true).build();
                    observer.onNext(response);
                }

                if (clusterObserver != null) {  // 负责提交的Manager需要关闭和集群其他节点的通信
                    clusterObserver.onCompleted();
                } else {
                    observer.onCompleted();
                }

                trainerObserver.onCompleted();
                logger.info("job submit completed!!!!");
            }
        };
    }

    @Override
    public void jobShutdown(JobShutdownRequest request, StreamObserver<JobShutdownResponse> responseObserver) {

        managerState.deleteJobState(request.getSourceId(), request.getUuid());
        responseObserver.onNext(JobShutdownResponse.getDefaultInstance());
        responseObserver.onCompleted();
    }
}
