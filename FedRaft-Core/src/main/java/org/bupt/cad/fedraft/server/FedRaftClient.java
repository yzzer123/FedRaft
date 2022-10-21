package org.bupt.cad.fedraft.server;

import io.grpc.Deadline;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.bupt.cad.fedraft.beans.NodeInfo;
import org.bupt.cad.fedraft.beans.Tuple;
import org.bupt.cad.fedraft.config.Configuration;
import org.bupt.cad.fedraft.node.Runtime;
import org.bupt.cad.fedraft.rpc.message.*;
import org.bupt.cad.fedraft.rpc.service.FedRaftServiceGrpc;
import org.bupt.cad.fedraft.utils.PingUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class FedRaftClient {

    private static final Logger logger = LoggerFactory.getLogger(FedRaftClient.class);

    private final ManagedChannel channel;
    private final NodeInfo clientInfo;

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

    public FedRaftClient(NodeInfo nodeInfo) {
        this(nodeInfo, false);
    }

    public FedRaftClient(NodeInfo nodeInfo, boolean isForTrainer) {
        this.channel = ManagedChannelBuilder.forAddress(nodeInfo.getIp(), isForTrainer ? nodeInfo.getTrainerPort() : nodeInfo.getPort())
                .usePlaintext().enableRetry().build();
        this.blockingStub = FedRaftServiceGrpc.newBlockingStub(channel);
        this.asyncStub = FedRaftServiceGrpc.newStub(channel);
        this.futureStub = FedRaftServiceGrpc.newFutureStub(channel);
        this.clientInfo = nodeInfo;
    }

    //向client发送心跳信息 并处理返回值
    public void sendHeartBeat(HeartbeatRequest request, HeartbeatResponseHandler responseHandler) {

        if (logger.isDebugEnabled())
            logger.debug("send heartbeat to {}", clientInfo);

        getAsyncStub().withDeadline(Deadline.after(Configuration.getInt(Configuration.MANAGER_HEARTBEAT_TIMEOUT), TimeUnit.MILLISECONDS))
                .heartbeat(request, new StreamObserver<>() {
                    @Override
                    public void onNext(HeartbeatResponse heartbeatResponse) {
                        if (logger.isDebugEnabled())
                            logger.debug("received heartbeat response from {} with delay={}", clientInfo, heartbeatResponse.getNetworkDelay());
                        responseHandler.handleResponse(heartbeatResponse);
                        if (logger.isDebugEnabled())
                            logger.debug("updated topology = {}", Runtime.getRuntime().getTopology());
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        if (logger.isDebugEnabled())
                            logger.debug("heartbeat failed: " + throwable.getMessage());

                        Runtime.getRuntime().getTopology().computeIfPresent(clientInfo.getNodeId(), (k, oldDelay) -> {
                            if (oldDelay.getRight() < request.getTimestamp()) {
                                oldDelay.setTuple(PingUtils.INVALID_DELAY, System.currentTimeMillis());
                            }
                            return oldDelay;
                        });

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

    //  和trainer保持同步
    public void syncWithTrainer() {

        Map<Long, Tuple<Integer, Long>> topology = Runtime.getRuntime().getTopology();
        SyncWithTrainerRequest.Builder requestBuilder = SyncWithTrainerRequest.newBuilder();
        Runtime runtime = Runtime.getRuntime();
        synchronized (Runtime.getRuntime()) {
            requestBuilder.setTerm(runtime.getTerm())
                    .setLeaderId(runtime.getLeaderInfo().getNodeId())
                    .setNodeState(runtime.getState());
        }

        synchronized (runtime.getTopology()) {
            requestBuilder.addAllNodeIds(topology.keySet());
        }
        SyncWithTrainerRequest request = requestBuilder.build();
        getAsyncStub().withDeadline(Deadline.after(Configuration.getInt(Configuration.MANAGER_SYNC_TIMEOUT), TimeUnit.MILLISECONDS))
                .syncWithTrainer(request, new StreamObserver<>() {
                    @Override
                    public void onNext(SyncWithTrainerResponse response) {
                        // 更新本地模型索引
                        Runtime.getRuntime().setModelIndex(response.getCurrentModelIndex());
                        if (logger.isDebugEnabled())
                            logger.debug("sync succeed and updated local model index = {}", response.getCurrentModelIndex());
                    }

                    @Override
                    public void onError(Throwable t) {
//                if (logger.isDebugEnabled())
//                    logger.debug("sync with trainer failed: {}", t.getMessage());
                    }

                    @Override
                    public void onCompleted() {

                    }
                });
    }

    // 用于时延测试


    public interface HeartbeatResponseHandler {
        void handleResponse(HeartbeatResponse response);

    }
}
