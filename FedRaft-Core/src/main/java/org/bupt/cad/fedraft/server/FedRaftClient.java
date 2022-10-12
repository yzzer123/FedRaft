package org.bupt.cad.fedraft.server;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bupt.cad.fedraft.beans.NodeInfo;
import org.bupt.cad.fedraft.rpc.message.HeartbeatRequest;
import org.bupt.cad.fedraft.rpc.message.HeartbeatResponse;
import org.bupt.cad.fedraft.rpc.service.FedRaftServiceGrpc;

import java.util.Map;

public class FedRaftClient {
    private static final Logger logger = LogManager.getLogger(FedRaftServer.class.getName());


    private final ManagedChannel channel;

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

    private final FedRaftServiceGrpc.FedRaftServiceBlockingStub blockingStub;
    private final FedRaftServiceGrpc.FedRaftServiceStub asyncStub;
    private final FedRaftServiceGrpc.FedRaftServiceFutureStub futureStub;

    public FedRaftClient(String host, int port) {
        this.channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build(); //usePlaintext()!
        this.blockingStub = FedRaftServiceGrpc.newBlockingStub(channel);
        this.asyncStub = FedRaftServiceGrpc.newStub(channel);
        this.futureStub = FedRaftServiceGrpc.newFutureStub(channel);
    }

    //向Server发送心跳信息: term, leader_id,
    public void sendHeartBeat(int term, long leaderInfo, NodeInfo clientInfo){
        HeartbeatRequest.Builder builder = HeartbeatRequest.newBuilder().setTerm(term).setLeaderId(leaderInfo);
        for(Map.Entry<NodeInfo, Float> topology: Node.topologies.entrySet()){
            //repeated type: use add not set!
            builder.addNodeIds(topology.getKey().getNodeId());
            builder.addNetworkDelays(topology.getValue());
        }
        HeartbeatRequest request = builder.build();
        getAsyncStub().heartbeat(request, new StreamObserver<HeartbeatResponse>() {
            @Override
            public void onNext(HeartbeatResponse heartbeatResponse) {
                logger.info("get heartbeat response from " + clientInfo.getIp());
                float newDelay = heartbeatResponse.getNetworkDelay();
                Node.topologies.put(clientInfo, newDelay);
            }

            @Override
            public void onError(Throwable throwable) {
                logger.error("发生意外的错误, (可能心跳信息超时或宕机)" + throwable.getMessage());//todo:不同异常的处理
                Node.clientFutures.get(clientInfo).cancel(true);//终止向该线程发送心跳信息
            }

            @Override
            public void onCompleted() {
                logger.info("follower节点接收到本次心跳信息");
            }
        });
    }
}
