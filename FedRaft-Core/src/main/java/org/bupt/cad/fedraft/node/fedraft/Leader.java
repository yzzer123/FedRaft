package org.bupt.cad.fedraft.node.fedraft;

import org.bupt.cad.fedraft.beans.Tuple;
import org.bupt.cad.fedraft.config.Configuration;
import org.bupt.cad.fedraft.rpc.message.HeartbeatRequest;
import org.bupt.cad.fedraft.rpc.message.NodeState;
import org.bupt.cad.fedraft.rpc.message.VoteRequest;
import org.bupt.cad.fedraft.utils.ClientPool;
import org.bupt.cad.fedraft.utils.PingUtils;
import org.bupt.cad.fedraft.utils.TimerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Leader extends Node {

    private static final Logger logger = LoggerFactory.getLogger(Leader.class);

    private final Map<Long, Tuple<Integer, Long>> topology = getRuntime().getTopology();
    private final ClientPool clientPool = getRuntime().getClientPool();
    private ScheduledFuture<?> heartbeatTask;

    public Leader(Runtime runtime) {
        super(runtime);
        if (logger.isDebugEnabled()) {
            logger.debug("{} became leader in term : {}", getRuntime().getSelfNodeInfo(), getRuntime().getTerm());
        }
        getRuntime().setLeader(getRuntime().getSelfNodeInfo().getNodeId());
        maintainHeartbeat();
    }

    @Override
    public int receiveHeartbeat(HeartbeatRequest request) {
        Runtime runtime = getRuntime();

        // TMP LEADER 直接返回时延，但是不对自己做任何更新
        if (request.getLeaderState() == NodeState.TMP_LEADER) {
            return runtime.getDelay();
        }

        // 判断任期是否比自己大
        if (request.getTerm() > runtime.getTerm()) {
            // 跟随该leader 将任期提升
            runtime.setTerm(request.getTerm())
                    .setLeader(request.getLeaderId());
            runtime.setState(NodeState.FOLLOWER);  // 直接转变为follower

            // 更新拓扑
            updateTopology(request.getNodeIdsList(), request.getNetworkDelaysList(), request.getTimestamp());
            return runtime.getDelay();
        }
        // 任期比自己小就为错误 不更新拓扑
        return -1;
    }

    // 如果有更高任期的节点请求投票，就进行角色转换
    @Override
    public boolean voteFor(VoteRequest request) {
        Runtime runtime = getRuntime();
        if (request.getTerm() > runtime.getTerm()) {
            if (logger.isDebugEnabled()){
                logger.debug("leader received a vote request, become a follower!");
            }

            runtime.setState(NodeState.FOLLOWER);
            return runtime.<Follower>getNodeMode().voteFor(request);
        }
        return false;
    }


    private void maintainHeartbeat() {

        int heartbeatInterval = Configuration.getInt(Configuration.MANAGER_HEARTBEAT_TIME_INTERVAL);

        if (logger.isDebugEnabled())
            logger.debug("leader begin maintainHeartbeat");

        // end runnable method
        heartbeatTask = TimerUtils.getTimer().scheduleAtFixedRate(this::heartbeatOnce, 0, heartbeatInterval, TimeUnit.MILLISECONDS);
    }

    private void heartbeatOnce() {

        HeartbeatRequest.Builder builder = HeartbeatRequest.newBuilder();

        Runtime runtime = getRuntime();
        runtime.lockRuntime(false);
            // 如果角色变化 就不能再发心跳
            if (runtime.getNodeMode() != this) {
                runtime.unlockRuntime(false);

                return;
            }

            builder = builder.setLeaderModelIndex(runtime.getModelIndex())
                    .setLeaderState(NodeState.LEADER)
                    .setTerm(runtime.getTerm())
                    .setLeaderId(runtime.getSelfNodeInfo().getNodeId());
        runtime.unlockRuntime(false);

        // 构造请求中的时延列表
        if (logger.isDebugEnabled()) {
            logger.debug("send topology = {}", topology);
        }
        runtime.lockTopology(false);
        for (Map.Entry<Long, Tuple<Integer, Long>> entry : topology.entrySet()) {
            builder.addNodeIds(entry.getKey());
            builder.addNetworkDelays(entry.getValue().getLeft());
        }
        runtime.unlockTopology(false);

        long selfId = runtime.getSelfNodeInfo().getNodeId();
        builder.setTimestamp(System.currentTimeMillis());

        HeartbeatRequest request = builder.build();

        // 发送的客户端
        List<Long> clientList = request.getNodeIdsList();

        for (Long clientId : clientList) {

            // 将自己排除掉
            if (clientId.equals(selfId)) {
                continue;
            }

            runtime.getThreadPool().submit(() -> {
                // 获取通信通道并发送心跳
                clientPool.getChannel(clientId).sendHeartBeat(request, response -> {
                    int newDelay = response.getNetworkDelay();
                    // 更新心跳信息
                    if (newDelay > 0) {
                        // 加权更新
                        runtime.lockTopology(true);
                        topology.computeIfPresent(clientId, (id, oldDelay) -> {
                            if (response.getTimestamp() < oldDelay.getRight() || oldDelay.getLeft() == PingUtils.INVALID_DELAY
                                    || oldDelay.getLeft() == -1) {
                                oldDelay.setLeft(newDelay);
                            } else {
                                // 对时延进行平滑处理 避免摆动过大
                                oldDelay.setLeft((7 * newDelay + 3 * oldDelay.getLeft()) / 10);
                            }
                            oldDelay.setRight(response.getTimestamp());
                            return oldDelay;
                        });
                        runtime.unlockTopology(true);

                    }
                });// end method call
            });

        }
    }

    @Override
    public void close() {
        if (heartbeatTask != null) {
            heartbeatTask.cancel(true);
        }
    }
}
