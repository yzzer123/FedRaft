package org.bupt.cad.fedraft.server;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.bupt.cad.fedraft.node.Runtime;
import org.bupt.cad.fedraft.rpc.message.HeartbeatRequest;
import org.bupt.cad.fedraft.rpc.message.HeartbeatResponse;
import org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest;
import org.bupt.cad.fedraft.rpc.message.TriggerElectionResponse;
import org.bupt.cad.fedraft.rpc.service.FedRaftServiceGrpc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FedRaftClient {

    private static final Logger logger = LoggerFactory.getLogger(FedRaftClient.class);

    private final ManagedChannel channel;
    private final int port;
    private final String host;

    public ManagedChannel getChannel() {
        return channel;
    }

    public FedRaftServiceGrpc.FedRaftServiceBlockingStub getBlockingStub() {
        return blockingStub;
    }

    public FedRaftServiceGrpc.FedRaftServiceStub getAsyncStub() {
        return asyncStub;
    }

    public FedRaftServiceGrpc.FedRaftServiceFutureStub getFutureStub() {
        return futureStub;
    }

    public void close() {
        channel.shutdownNow();
    }

    private final FedRaftServiceGrpc.FedRaftServiceBlockingStub blockingStub;
    private final FedRaftServiceGrpc.FedRaftServiceStub asyncStub;
    private final FedRaftServiceGrpc.FedRaftServiceFutureStub futureStub;

    public FedRaftClient(String host, int port) {
        this.channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().enableRetry().build(); //usePlaintext()!
        this.blockingStub = FedRaftServiceGrpc.newBlockingStub(channel);
        this.asyncStub = FedRaftServiceGrpc.newStub(channel);
        this.futureStub = FedRaftServiceGrpc.newFutureStub(channel);
        this.host = host;
        this.port = port;
    }

    //向client发送心跳信息 并处理返回值
    public void sendHeartBeat(HeartbeatRequest request, HeartbeatResponseHandler responseHandler) {

        logger.info("send heartbeat to {} {}", host, port);

        getAsyncStub().heartbeat(request, new StreamObserver<>() {
            @Override
            public void onNext(HeartbeatResponse heartbeatResponse) {
                logger.info("received heartbeat response from {} {}", host, port);
                responseHandler.handleResponse(heartbeatResponse);
                logger.info("updated topology = {}", Runtime.getRuntime().getTopology());
            }

            @Override
            public void onError(Throwable throwable) {
                logger.error("heartbeat invalid: " + throwable.getMessage());
            }

            @Override
            public void onCompleted() {
            }
        });
    }

    public void triggerElection(TriggerElectionRequest request) {
        getAsyncStub().triggerElection(request, new StreamObserver<>() {
            @Override
            public void onNext(TriggerElectionResponse value) {

            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {

            }
        });
    }

//    // 和trainer保持同步
//    public void

    public interface HeartbeatResponseHandler {
        void handleResponse(HeartbeatResponse response);
    }
}
