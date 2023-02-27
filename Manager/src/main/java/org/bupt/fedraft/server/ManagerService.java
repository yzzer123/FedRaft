package org.bupt.fedraft.server;

import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import org.bupt.fedraft.beans.Tuple;
import org.bupt.fedraft.rpc.jobmanager.message.JobShutdownRequest;
import org.bupt.fedraft.rpc.jobmanager.message.JobShutdownResponse;
import org.bupt.fedraft.rpc.manager.message.*;
import org.bupt.fedraft.rpc.manager.service.ManagerServiceGrpc;
import org.bupt.fedraft.rpc.trainer.message.InitModelRequest;
import org.bupt.fedraft.state.JobManager;
import org.bupt.fedraft.state.ManagerState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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


        return new StreamObserver<>() {

            private StreamObserver<JobSubmitRequest> clusterObserver;

            private StreamObserver<InitModelRequest> trainerObserver;

            private JobManager jobState;

            @Override
            public void onNext(JobSubmitRequest request) {
                // 收到提交的任务初始化请求
                if (request.hasConf()) {
                    if (request.getConf().getSourceId() == 0L) { // 从client发出的提交请求需要填入sourceId
                        if (logger.isDebugEnabled()) {
                            JobConfiguration conf = request.getConf();
                            logger.debug("receive job submit from client:\n" +
                                    "uuid={}, " +
                                    "list={}, " +
                                    "file={}\n", conf.getUuid(), conf.getParticipantsList(), conf.getCodeFile().getFileName());
                        }

                        // 构造转发请求，填入源ID
                        JobConfiguration jobConf = request.getConf().toBuilder()
                                .setSourceId(managerState.getSelfNodeInfo()
                                        .getNodeId()).build();
                        request = request.toBuilder().setConf(jobConf).build();

                        // 初始化 observer
                        clusterObserver = ManagerClient.submitJobOnCluster(
                                managerState,
                                request.getConf().getUuid(),
                                request.getConf().getParticipantsList());

                        // 在集群内创建任务
                        clusterObserver.onNext(request);
                    }
                    // 收到来自source的提交请求 检查配置是否合法
                    if (managerState.getJobState(request.getConf().getSourceId(),
                            request.getConf().getUuid()) != null) {  // uuid不合法 无法创建
                        logger.warn("job conf is invalid, fail to load");

                        JobSubmitResponse failResponse = JobSubmitResponse.newBuilder()
                                .setLogs("uuid is invalid").build();
                        JobSubmitResponse failResponse2 = JobSubmitResponse.newBuilder()
                                .setSuccess(false).build();

                        responseObserver.onNext(failResponse);
                        responseObserver.onNext(failResponse2);
                        responseObserver.onCompleted();
                        return;
                    }
                    // 初始化本地的job state
                    jobState = new JobManager(managerState, request.getConf().getUuid(),
                            request.getConf().getSourceId(),
                            request.getConf().getParticipantsList(),
                            responseObserver);

                    managerState.addJobState(jobState);

                    trainerObserver = jobState.getTrainerClient().initModel();

                }

                if (request.hasModelChunk()) {
                    if (jobState == null) { // 没有提前创建配置
                        logger.warn("model chunk arrived without job conf");
                        JobSubmitResponse failResponse = JobSubmitResponse.newBuilder()
                                .setSuccess(false).build();
                        responseObserver.onNext(failResponse);
                        responseObserver.onCompleted();
                        responseObserver.onError(Status.PERMISSION_DENIED
                                .withDescription("model chunk arrived without job conf")
                                .asException());
                        return;
                    }
                    jobState.model.add(request.getModelChunk());

                    // 向trainer发送模型
                    trainerObserver.onNext(InitModelRequest.newBuilder()
                            .setModelChunk(request.getModelChunk()).build());

                    if (clusterObserver != null) {
                        clusterObserver.onNext(request);
                    }
                }
            }

            @Override
            public void onError(Throwable t) {
                responseObserver.onError(t);
            }

            @Override
            public void onCompleted() {
                JobManager existed = managerState.getJobState(jobState.sourceId, jobState.uuid);
                if (existed != null) {
                    // 当前manager保存了job state状态，说明启动成功
                    JobSubmitResponse response = JobSubmitResponse.newBuilder()
                            .setSuccess(true).build();
                    responseObserver.onNext(response);
                    responseObserver.onCompleted();
                }

                if (clusterObserver != null) {  // 负责提交的Manager需要关闭和集群其他节点的通信
                    clusterObserver.onCompleted();
                }
                trainerObserver.onCompleted();
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
