package org.bupt.cad.fedraft.server;


import io.grpc.stub.StreamObserver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bupt.cad.fedraft.algorithm.Algorithm;
import org.bupt.cad.fedraft.rpc.message.HeartbeatRequest;
import org.bupt.cad.fedraft.rpc.message.HeartbeatResponse;
import org.bupt.cad.fedraft.rpc.message.LogRequest;
import org.bupt.cad.fedraft.rpc.message.LogResponse;
import org.bupt.cad.fedraft.rpc.service.FedRaftServiceGrpc;


/**
 * RPC通信服务实现类
 */
public class FedRaftService extends FedRaftServiceGrpc.FedRaftServiceImplBase {


    private static final Logger logger = LogManager.getLogger(FedRaftServer.class.getName());
    private final Algorithm algorithm;

    public FedRaftService(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    //todo 建立计时器感知超时
    @Override
    public void heartbeat(HeartbeatRequest request, StreamObserver<HeartbeatResponse> responseObserver) {

        int delay = algorithm.heartbeat(request);
        if (delay > 0) {
            HeartbeatResponse response = HeartbeatResponse.newBuilder().setNetworkDelay(delay).build();
            responseObserver.onNext(response);
            logger.info("follower节点完成一次心跳传输");
        }
        logger.info("delay=" + delay);
        responseObserver.onCompleted();
    }

    @Override
    public void appendLog(LogRequest request, StreamObserver<LogResponse> responseObserver) {

    }

}
