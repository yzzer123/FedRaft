package org.bupt.cad.fedraft.node.fedraft;


import org.bupt.cad.fedraft.beans.NodeInfo;
import org.bupt.cad.fedraft.beans.Tuple;
import org.bupt.cad.fedraft.config.Configuration;
import org.bupt.cad.fedraft.rpc.message.HeartbeatRequest;
import org.bupt.cad.fedraft.rpc.message.NodeState;
import org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest;
import org.bupt.cad.fedraft.rpc.message.VoteRequest;
import org.bupt.cad.fedraft.utils.ClientPool;
import org.bupt.cad.fedraft.utils.PingUtils;
import org.bupt.cad.fedraft.utils.TimerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * tmp leader的作用:
 * 1. 临时维护集群的时延信息，保障集群从安全模式过度到工作模式
 * 2. 监控集群follower的数量，当follower >= num of cluster/2 时触发leader的选举
 * 3. 临时从zk中监控集群，但不负责维护集群的节点改变，集群节点变更需要通过leader维护
 * 4. 触发选举后，自己变为follower
 */
public class TmpLeader extends Node {
    private static final Logger logger = LoggerFactory.getLogger(TmpLeader.class);

    private final Map<Long, Tuple<Integer, Long>> topology = getRuntime().getTopology();
    private final ClientPool clientPool = getRuntime().getClientPool();
    private ScheduledFuture<?> heartbeatTask;

    private final ConcurrentHashMap<Long, Long> followerSet = new ConcurrentHashMap<>();


    public TmpLeader(Runtime runtime) {
        super(runtime);
        getRuntime().addTerm();
        // 将自己设置为leader
        getRuntime().setLeader(getRuntime().getSelfNodeInfo().getNodeId());
        initCluster();
        maintainHeartbeat();
    }

    public void initCluster() {
        try {

            List<NodeInfo> cluster = getRuntime().getZkClient().getCluster();

            if (cluster.size() < 3) {
                logger.error("初始化集群失败");
                getRuntime().getZkClient().giveUpCheckinLeader(true);
                System.exit(1);
            }
            getRuntime().lockTopology(true);
            for (NodeInfo nodeInfo : cluster) {
                topology.put(nodeInfo.getNodeId(), new Tuple<>(-1, 0L));
            }
            getRuntime().unlockTopology(true);
        } catch (Exception e) {
            // 监听器设置失败就直接退出
            logger.error("初始化集群失败" + e.getMessage(), e);
            getRuntime().getZkClient().giveUpCheckinLeader(true);
            System.exit(1);
        }
    }

    // 开启定时发送心跳任务
    private void maintainHeartbeat() {

        int heartbeatInterval = Configuration.getInt(Configuration.MANAGER_HEARTBEAT_TIME_INTERVAL);
        if (logger.isDebugEnabled())
            logger.debug("tmp leader begin maintainHeartbeat");

        // end runnable method
        heartbeatTask = TimerUtils.getTimer().scheduleAtFixedRate(() -> {
            // 计算存活follower数量
            followerSet.values().removeIf(timestamp -> timestamp + heartbeatInterval * 3L < System.currentTimeMillis());
            // 集群节点达到2以上才能正常运行
            if (topology.size() > 2 && followerSet.size() + 1 > topology.size() / 2) {
                if (logger.isDebugEnabled())
                    logger.debug("tmp leader trigger election");
                triggerElection();
                return;
            }

            heartbeatOnce();
        }, 0, heartbeatInterval, TimeUnit.MILLISECONDS);
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

        builder = builder.setLeaderModelIndex(0)
                .setTerm(runtime.getTerm())
                .setLeaderState(NodeState.TMP_LEADER)
                .setLeaderId(runtime.getSelfNodeInfo().getNodeId());

        // 构造请求中的时延列表
        runtime.lockTopology(false);
        if (logger.isDebugEnabled()) {
            logger.debug("send topology = {}", topology);
        }
        for (Map.Entry<Long, Tuple<Integer, Long>> entry : topology.entrySet()) {
            builder.addNodeIds(entry.getKey());
            builder.addNetworkDelays(entry.getValue().getLeft());
        }
        runtime.unlockTopology(false);
        runtime.unlockRuntime(false);

        builder.setTimestamp(System.currentTimeMillis());
        HeartbeatRequest request = builder.build();

        long selfId = runtime.getSelfNodeInfo().getNodeId();
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
                        topology.computeIfPresent(clientId, (id, oldDelay) -> {
                            if (response.getTimestamp() < oldDelay.getRight() || oldDelay.getLeft() == PingUtils.INVALID_DELAY || oldDelay.getLeft() == -1) {
                                oldDelay.setLeft(newDelay);
                            } else {
                                // 对时延进行平滑处理 避免摆动过大
                                oldDelay.setLeft((7 * newDelay + 3 * oldDelay.getLeft()) / 10);
                            }
                            oldDelay.setRight(response.getTimestamp());
                            return oldDelay;
                        });
                        // 统计存活follower数量
                        if (response.getNodeState() != NodeState.SAFE_MODE) {
                            followerSet.put(clientId, System.currentTimeMillis());
                        }
                    }
                });// end method call
            });
        }
    }

    /**
     * 触发选举
     */
    private void triggerElection() {
        // 选举前再发送一次心跳，保持时延拓扑最新
        Runtime runtime = getRuntime();
        TriggerElectionRequest request;
        runtime.lockRuntime(true);
        // 如果节点已经不是tmp leader 就不要触发选举
        if (runtime.getNodeMode() != this) {
            runtime.unlockRuntime(true);
            return;
        }

        heartbeatOnce();

        // 构造请求
        request = TriggerElectionRequest.newBuilder()
                .setTerm(runtime.getTerm())
                .setLeaderId(runtime.getLeaderInfo().getNodeId())
                .setLeaderModelIndex(runtime.getModelIndex())
                .build();

        // 触发follower选举
        for (Long follower : followerSet.keySet()) {
            getRuntime().getThreadPool().submit(() ->
                    clientPool.getChannel(follower).triggerElection(request));
        }

        // 变换状态为follower 需要在对runtime加锁的代码中
        runtime.setState(NodeState.FOLLOWER);
        // 触发自己选举
        triggerElection(request);
        runtime.unlockRuntime(true);

    }

    @Override
    public void close() {
        // 停止心跳的发送
        if (heartbeatTask != null) {
            heartbeatTask.cancel(true);
            // 放弃leader主权
            getRuntime().getZkClient().giveUpCheckinLeader(true);
        }
    }

    /**
     * 接收到来自更高任期的leader的心跳后就直接转换为follower
     *
     * @param request 心跳请求
     * @return 返回时延
     */
    @Override
    public int receiveHeartbeat(HeartbeatRequest request) {

        Runtime runtime = getRuntime();

        // 判断任期是否比自己大
        // tmp leader 可能收到来自 leader的心跳信息,
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

    // Tmp leader 无法投票
    @Override
    public boolean voteFor(VoteRequest request) {
        return false;
    }

}
