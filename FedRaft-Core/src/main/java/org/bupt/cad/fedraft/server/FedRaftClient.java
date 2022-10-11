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
        this.channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        this.blockingStub = FedRaftServiceGrpc.newBlockingStub(channel);
        this.asyncStub = FedRaftServiceGrpc.newStub(channel);
        this.futureStub = FedRaftServiceGrpc.newFutureStub(channel);
    }

    //向Server发送心跳信息: term, leader_id,
    public void sendHeartBeat(int term, long leaderInfo, NodeInfo clientInfo){
        HeartbeatRequest.Builder builder = HeartbeatRequest.newBuilder().setTerm(term).setLeaderId(leaderInfo);
        int index = 0;
        for(Map.Entry<NodeInfo, Float> topology: Node.topologies.entrySet()){
            builder.setNodeIds(index, topology.getKey().getNodeId());
            builder.setNetworkDelays(index, topology.getValue());
            index += 1;
        }
        HeartbeatRequest request = builder.build();
        asyncStub.heartbeat(request, new StreamObserver<HeartbeatResponse>() {
            @Override
            public void onNext(HeartbeatResponse heartbeatResponse) {
                logger.info("get heartbeat response from " + clientInfo.getIp());
                float newDelay = heartbeatResponse.getNetworkDelay();
                Node.topologies.put(clientInfo, newDelay);
            }

            @Override
            public void onError(Throwable throwable) {
                logger.error("发送意外的错误, (可能心跳信息超时或服务器宕机)" + throwable.getMessage());
                //to do
            }

            @Override
            public void onCompleted() {
                logger.info("follower节点终止本轮心跳信息");
            }
        });
    }
}
