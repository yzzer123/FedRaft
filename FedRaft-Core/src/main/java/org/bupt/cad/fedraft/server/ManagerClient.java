package org.bupt.cad.fedraft.server;

import io.grpc.Deadline;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.bupt.cad.fedraft.beans.NodeInfo;
import org.bupt.cad.fedraft.beans.Tuple;
import org.bupt.cad.fedraft.config.Configuration;
import org.bupt.cad.fedraft.node.fedraft.ElectionExecutor;
import org.bupt.cad.fedraft.node.fedraft.Runtime;
import org.bupt.cad.fedraft.rpc.message.*;
import org.bupt.cad.fedraft.rpc.service.ManagerServiceGrpc;
import org.bupt.cad.fedraft.rpc.service.NodeInnerContactServiceGrpc;
import org.bupt.cad.fedraft.utils.PingUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ManagerClient {

    private static final Logger logger = LoggerFactory.getLogger(ManagerClient.class);

    private final ManagedChannel channel;
    private final NodeInfo clientInfo;

    public ManagedChannel getChannel() {
        return channel;
    }
    private final ManagerServiceGrpc.ManagerServiceBlockingStub blockingStub;
    private final ManagerServiceGrpc.ManagerServiceStub asyncStub;

    public void close() {
        channel.shutdownNow();
    }
    private final NodeInnerContactServiceGrpc.NodeInnerContactServiceStub clientAsyncStub;
    private final Runtime runtime;
    public ManagerClient(Runtime runtime, NodeInfo nodeInfo) {
        this(runtime, nodeInfo, false);
    }

    public ManagerClient(Runtime runtime, NodeInfo nodeInfo, boolean isForTrainer) {
        this.channel = ManagedChannelBuilder.forAddress(nodeInfo.getIp(), isForTrainer ? nodeInfo.getTrainerPort() : nodeInfo.getPort())
                .usePlaintext().enableRetry().build();
        this.blockingStub = ManagerServiceGrpc.newBlockingStub(channel);
        this.asyncStub = ManagerServiceGrpc.newStub(channel);
        this.clientAsyncStub = NodeInnerContactServiceGrpc.newStub(channel);
        this.clientInfo = nodeInfo;
        this.runtime = runtime;
    }

    public ManagerServiceGrpc.ManagerServiceBlockingStub getBlockingStub() {
        return blockingStub;
    }

    public ManagerServiceGrpc.ManagerServiceStub getAsyncStub() {
        return asyncStub;
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
                            logger.debug("updated topology = {}", runtime.getTopology());
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        if (logger.isDebugEnabled())
                            logger.debug("heartbeat failed: " + throwable.getMessage());

                        runtime.getTopology().computeIfPresent(clientInfo.getNodeId(), (k, oldDelay) -> {
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

        Map<Long, Tuple<Integer, Long>> topology = runtime.getTopology();
        SyncWithTrainerRequest.Builder requestBuilder = SyncWithTrainerRequest.newBuilder();
        runtime.lockRuntime(false);
        requestBuilder.setTerm(runtime.getTerm())
                .setLeaderId(runtime.getLeaderInfo().getNodeId())
                .setNodeState(runtime.getState());
        runtime.unlockRuntime(false);

        runtime.lockTopology(false);
        requestBuilder.addAllNodeIds(topology.keySet());
        runtime.unlockTopology(false);
        SyncWithTrainerRequest request = requestBuilder.build();
        getClientAsyncStub().withDeadline(Deadline.after(Configuration.getInt(Configuration.MANAGER_SYNC_TIMEOUT), TimeUnit.MILLISECONDS))
                .syncWithTrainer(request, new StreamObserver<>() {
                    @Override
                    public void onNext(SyncWithTrainerResponse response) {
                        // 更新本地模型索引
                        runtime.setModelIndex(response.getCurrentModelIndex());
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

    // 请求投票, 需要传递选举状态用于接受投票
    public void requestForVote(VoteRequest request, ElectionExecutor electionExecutor){
        getAsyncStub().requestVote(request, new StreamObserver<>() {
            @Override
            public void onNext(VoteResponse voteResponse) {
                // check node state, only candidate can receive a vote
                runtime.lockRuntime(false);
                    if (runtime.getState() != NodeState.CANDIDATE){
                        runtime.unlockRuntime(false);
                        return;
                    }
                runtime.unlockRuntime(false);

                // receive a vote
                if (voteResponse.getVoteGranted()){
                    electionExecutor.addVote();
                    if (logger.isDebugEnabled()){
                        logger.debug("received a vote from {}", clientInfo);
                    }
                }

                // update local topology
                runtime.getTopology().computeIfPresent(clientInfo.getNodeId(),
                        (clientId, oldDelay) -> {
                            if (oldDelay.getLeft() == PingUtils.INVALID_DELAY || oldDelay.getLeft() == -1) {
                                oldDelay.setLeft(voteResponse.getDelay());
                            }else{
                                // 对时延进行平滑处理 避免摆动过大
                                oldDelay.setLeft((7 * voteResponse.getDelay() + 3 * oldDelay.getLeft()) / 10);
                            }
                            oldDelay.setRight(System.currentTimeMillis());
                            return oldDelay;
                        });
            }

            @Override
            public void onError(Throwable throwable) {
                logger.warn("request vote err :{}", throwable.getMessage());
            }

            @Override
            public void onCompleted() {

            }
        });

    }

    public NodeInnerContactServiceGrpc.NodeInnerContactServiceStub getClientAsyncStub() {
        return clientAsyncStub;
    }


    public interface HeartbeatResponseHandler {
        void handleResponse(HeartbeatResponse response);

    }
}
