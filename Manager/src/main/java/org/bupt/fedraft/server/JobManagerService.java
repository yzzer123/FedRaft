package org.bupt.fedraft.server;

import io.grpc.stub.StreamObserver;
import org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest;
import org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogResponse;
import org.bupt.fedraft.rpc.manager.message.JobSubmitResponse;
import org.bupt.fedraft.rpc.manager.service.JobManagerServiceGrpc;
import org.bupt.fedraft.state.JobManager;
import org.bupt.fedraft.state.ManagerState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JobManagerService extends JobManagerServiceGrpc.JobManagerServiceImplBase {

    private static final Logger logger = LoggerFactory.getLogger(JobManagerService.class);
    private final ManagerState managerState;

    public JobManagerService(ManagerState managerState) {
        this.managerState = managerState;
    }

    /**
     * 负责接受训练过程中产生的训练日志
     */
    @Override
    public void appendLog(AppendJobLogRequest request, StreamObserver<AppendJobLogResponse> responseObserver) {

        if (request.getSourceId() != managerState.getSelfNodeInfo().getNodeId()) {
            // 转发日志
            ManagerClient client = managerState.getManagerClientPool().getClient(request.getSourceId());
            client.appendLog(request);
            responseObserver.onNext(AppendJobLogResponse.getDefaultInstance());
            responseObserver.onCompleted();
            return;
        }

        JobManager jobState = managerState.getJobState(request.getSourceId(), request.getUuid());
        if (jobState != null) {
            for (String log : request.getLogsList()) {
                JobSubmitResponse response = JobSubmitResponse.newBuilder()
                        .setLogs(log).build();
                jobState.responseObserver.onNext(response);
            }
        }
        responseObserver.onNext(AppendJobLogResponse.getDefaultInstance());
        responseObserver.onCompleted();
    }
}
