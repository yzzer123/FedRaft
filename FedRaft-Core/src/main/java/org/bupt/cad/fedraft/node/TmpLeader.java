package org.bupt.cad.fedraft.node;


import org.bupt.cad.fedraft.beans.NodeInfo;
import org.bupt.cad.fedraft.config.Configuration;
import org.bupt.cad.fedraft.rpc.message.HeartbeatRequest;
import org.bupt.cad.fedraft.rpc.message.NodeState;
import org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest;
import org.bupt.cad.fedraft.utils.ClientPool;
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
 * 4. 触发选举后，自己变为follower或candidate状态
 */
public class TmpLeader extends Node {

    private static final Logger logger = LoggerFactory.getLogger(TmpLeader.class);

    private final Map<Long, Integer> topology = Runtime.getRuntime().getTopology();
    private final ClientPool clientPool = Runtime.getRuntime().getClientPool();
    private ScheduledFuture<?> heartbeatTask;

    private final ConcurrentHashMap<Long, Long> followerSet = new ConcurrentHashMap<>();


    public TmpLeader() {
        Runtime.getRuntime().addTerm();
        // 将自己设置为leader
        Runtime.getRuntime().setLeader(Runtime.getRuntime().getSelfNodeInfo().getNodeId());
        initCluster();
        maintainHeartbeat();
    }

    public void initCluster() {
        try {

            List<NodeInfo> cluster = Runtime.getRuntime().getZkClient().getCluster();

            if (cluster.size() < 3) {
                logger.error("初始化集群失败");
                Runtime.getRuntime().getZkClient().giveUpCheckinLeader();
                System.exit(1);
            }

            synchronized (Runtime.getRuntime().getTopology()) {
                for (NodeInfo nodeInfo : cluster) {
                    topology.put(nodeInfo.getNodeId(), -1);
                }
            }
        } catch (Exception e) {
            // 监听器设置失败就直接退出
            logger.error("初始化集群失败" + e.getMessage(), e);
            Runtime.getRuntime().getZkClient().giveUpCheckinLeader();
            System.exit(1);
        }
    }

    // 开启定时发送心跳任务
    private void maintainHeartbeat() {

        int heartbeatInterval = Configuration.getInt(Configuration.NODE_HEARTBEAT_TIME_INTERVAL);
        logger.info("tmp leader begin maintainHeartbeat");

        // end runnable method
        heartbeatTask = TimerUtils.getTimer().scheduleAtFixedRate(() -> {
            // 计算存活follower数量
            followerSet.values().removeIf(timestamp -> timestamp + heartbeatInterval * 3L < System.currentTimeMillis());
            // 集群节点达到2以上才能正常运行
            if (topology.size() > 2 && followerSet.size() > topology.size() / 2) {
                logger.info("tmp leader trigger election");
                triggerElection();
            }

            heartbeatOnce();
        }, 10, heartbeatInterval, TimeUnit.MILLISECONDS);
    }


    private void heartbeatOnce() {

        HeartbeatRequest.Builder builder = HeartbeatRequest.newBuilder();
        builder = builder.setLeaderModelIndex(0)
                .setTerm(Runtime.getRuntime().getTerm())
                .setLeaderId(Runtime.getRuntime().getSelfNodeInfo().getNodeId());

        // 构造请求中的时延列表
        long selfId = Runtime.getRuntime().getSelfNodeInfo().getNodeId();
        synchronized (Runtime.getRuntime().getTopology()) {

            logger.info("send topology = {}", topology);
            for (Map.Entry<Long, Integer> entry : topology.entrySet()) {
                builder.addNodeIds(entry.getKey());
                builder.addNetworkDelays(entry.getValue());
            }
        }

        HeartbeatRequest request = builder.build();

        // 发送的客户端
        List<Long> clientList = request.getNodeIdsList();

        for (Long clientId : clientList) {

            // 将自己排除掉
            if (clientId.equals(selfId)) {
                continue;
            }

            // 获取通信通道并发送心跳
            clientPool.getChannel(clientId).sendHeartBeat(request, response -> {
                int networkDelay = response.getNetworkDelay();

                // 更新心跳信息
                if (networkDelay > 0) {
                    topology.computeIfPresent(clientId, (k, v) -> networkDelay);

                    // 统计存活follower数量
                    if (response.getNodeState() == NodeState.FOLLOWER) {
                        followerSet.put(clientId, System.currentTimeMillis());
                    }
                }
            });// end method call
        }
    }

    /**
     * 触发选举
     */
    private void triggerElection() {
        // 选举前再发送一次心跳，保持时延拓扑最新
        Runtime runtime = Runtime.getRuntime();
        synchronized (Runtime.getRuntime()) {
            if (runtime.getNodeMode() != this) {
                return;
            }
            heartbeatOnce();
            // 构造请求
            TriggerElectionRequest request = TriggerElectionRequest.newBuilder()
                    .setTerm(runtime.getTerm())
                    .setLeaderId(runtime.getLeaderInfo().getNodeId())
                    .setLeaderModelIndex(runtime.getModelIndex())
                    .build();

            // 触发
            for (Long follower : followerSet.keySet()) {
                clientPool.getChannel(follower).triggerElection(request);
            }
            // 触发自己
            heartbeatTask.cancel(true);
            Node.triggerElection(request);
        }
    }

    @Override
    public void close() {
        // 停止心跳的发送
        if (!isClosed() && heartbeatTask != null) {
            heartbeatTask.cancel(true);
            // 放弃leader主权
            Runtime.getRuntime().getZkClient().giveUpCheckinLeader();
            setClosed();
        }
    }

    /**
     * 接收到来自leader的心跳后就直接转换为follower
     *
     * @param request 心跳请求
     * @return 返回时延
     */
    @Override
    public int receiveHeartbeat(HeartbeatRequest request) {
        Runtime runtime = Runtime.getRuntime();
        // 判断任期是否比自己大
        // tmp leader 可能收到来自 leader的心跳信息,
        if (request.getTerm() > runtime.getTerm()) {
            // 跟随该leader 将任期提升
            runtime.setTerm(request.getTerm())
                    .setLeader(request.getLeaderId());
            runtime.setState(NodeState.FOLLOWER);  // 直接转变为follower

            // 更新拓扑
            updateTopology(request.getNodeIdsList(), request.getNetworkDelaysList());
            return runtime.getDelay().get();
        } else {
            // 任期比自己小就为错误 不更新拓扑
            return -1;
        }
    }
}
