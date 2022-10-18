package org.bupt.cad.fedraft.server;


import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import org.bupt.cad.fedraft.algorithm.Algorithm;
import org.bupt.cad.fedraft.node.Node;
import org.bupt.cad.fedraft.node.Runtime;
import org.bupt.cad.fedraft.rpc.message.*;
import org.bupt.cad.fedraft.rpc.service.FedRaftServiceGrpc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * RPC通信服务实现类
 */
public class FedRaftService extends FedRaftServiceGrpc.FedRaftServiceImplBase {


    private static final Logger logger = LoggerFactory.getLogger(FedRaftService.class);

    private final Algorithm algorithm;

    public FedRaftService(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    //todo 建立计时器感知超时
    @Override
    public void heartbeat(HeartbeatRequest request, StreamObserver<HeartbeatResponse> responseObserver) {
        HeartbeatResponse response = null;
        synchronized (Runtime.getRuntime()) {
            int delay = algorithm.heartbeat(request);
            if (delay > 0) {
                response = HeartbeatResponse.newBuilder()
                        .setNetworkDelay(delay)
                        .setNodeState(Runtime.getRuntime().getState())
                        .build();
                logger.info("follower has returned a response with delay={}", delay);
            }
        }
        if (response != null) {
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } else {
            responseObserver.onError(Status.INVALID_ARGUMENT.asException());
        }
    }

    @Override
    public void appendLog(LogRequest request, StreamObserver<LogResponse> responseObserver) {

    }

    @Override
    public void triggerElection(TriggerElectionRequest request, StreamObserver<TriggerElectionResponse> responseObserver) {
        synchronized (Runtime.getRuntime()) {
            Node.triggerElection(request);
        }
        // 回复默认值即可
        responseObserver.onNext(TriggerElectionResponse.getDefaultInstance());
        responseObserver.onCompleted();
    }
}
