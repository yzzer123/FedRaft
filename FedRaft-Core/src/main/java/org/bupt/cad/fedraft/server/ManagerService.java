package org.bupt.cad.fedraft.server;


import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import org.bupt.cad.fedraft.algorithm.Algorithm;
import org.bupt.cad.fedraft.beans.NodeInfo;
import org.bupt.cad.fedraft.rpc.message.*;
import org.bupt.cad.fedraft.rpc.service.ManagerServiceGrpc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * RPC通信服务实现类
 */
public class ManagerService extends ManagerServiceGrpc.ManagerServiceImplBase {


    private static final Logger logger = LoggerFactory.getLogger(ManagerService.class);

    private final Algorithm algorithm;

    public ManagerService(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    // 回复心跳信息
    @Override
    public void heartbeat(HeartbeatRequest request, StreamObserver<HeartbeatResponse> responseObserver) {
        HeartbeatResponse response = null;

        algorithm.getRuntime().lockRuntime(true);

        int delay = algorithm.heartbeat(request);
        if (delay > 0) {
            response = HeartbeatResponse.newBuilder()
                    .setNetworkDelay(delay)
                    .setNodeState(algorithm.getRuntime().getState())
                    .setTimestamp(System.currentTimeMillis())
                    .build();
            if (logger.isDebugEnabled())
                logger.debug("follower has returned a response with delay={}", delay);
        }
        algorithm.getRuntime().unlockRuntime(true);

        if (response != null) {
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } else {
            responseObserver.onError(Status.PERMISSION_DENIED.asRuntimeException());
        }

    }

    @Override
    public void triggerElection(TriggerElectionRequest request, StreamObserver<TriggerElectionResponse> responseObserver) {

        algorithm.getRuntime().getNodeMode().triggerElection(request);


        // 回复默认值即可
        responseObserver.onNext(TriggerElectionResponse.getDefaultInstance());
        responseObserver.onCompleted();
    }

    @Override
    public void requestVote(VoteRequest request, StreamObserver<VoteResponse> responseObserver) {
        VoteResponse.Builder responseBuilder = VoteResponse.newBuilder();

        algorithm.getRuntime().lockRuntime(true);

        responseBuilder.setTerm(algorithm.getRuntime().getTerm())
                .setDelay(algorithm.getRuntime().getDelay())
                .setVoteGranted(algorithm.voteFor(request));

        algorithm.getRuntime().unlockRuntime(true);
        VoteResponse voteResponse = responseBuilder.build();

        logger.info("vote for {} with granted: {}", new NodeInfo(request.getCandidateId()), voteResponse.getVoteGranted());

        responseObserver.onNext(voteResponse);
        responseObserver.onCompleted();
    }
}
