package org.bupt.cad.fedraft.node;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bupt.cad.fedraft.beans.NodeInfo;
import org.bupt.cad.fedraft.config.Configuration;
import org.bupt.cad.fedraft.rpc.message.HeartbeatRequest;
import org.bupt.cad.fedraft.rpc.message.HeartbeatResponse;
import org.bupt.cad.fedraft.rpc.message.NodeState;
import org.bupt.cad.fedraft.server.FedRaftClient;
import org.bupt.cad.fedraft.server.FedRaftServer;
import org.bupt.cad.fedraft.utils.ClientPool;
import org.bupt.cad.fedraft.utils.TimerUtils;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class TmpLeader implements NodeMode {

    private static final Logger logger = LogManager.getLogger(FedRaftServer.class.getName());

    private final Map<Long, Integer> topology = Node.getRuntimeNode().getTopology();
    private final ClientPool clientPool = Node.getRuntimeNode().getClientPool();
    private ScheduledFuture<?> heartbeatTask;

    private ConcurrentHashMap<Long, Long> followerSet = new ConcurrentHashMap<>();


    public TmpLeader() {
        Node.getRuntimeNode().addTerm();
        // 将自己设置为leader
        Node.getRuntimeNode().setLeader(Node.getRuntimeNode().getSelfNodeInfo().getNodeId());
        initCluster();
        maintainHeartbeat();

    }

    public void initCluster() {
        try {

            List<NodeInfo> cluster = Node.getRuntimeNode().getZkClient().getCluster();
            synchronized (Node.getRuntimeNode().getTopology()) {
                for (NodeInfo nodeInfo : cluster) {
                    topology.put(nodeInfo.getNodeId(), -1);
                }
            }
        } catch (Exception e) {
            // 监听器设置失败就直接退出
            logger.error("初始化集群失败" + e.getMessage(), e);
            System.exit(1);
        }
    }

    // TODO 开启定时发送心跳任务
    private void maintainHeartbeat() {

        int heartbeatInterval = Configuration.getInt(Configuration.NODE_HEARTBEAT_TIME_INTERVAL);
        heartbeatTask = TimerUtils.getTimer().scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                // 计算存活follower数量
                followerSet.values().removeIf(timestamp -> timestamp + heartbeatInterval * 3L < System.currentTimeMillis());
                if (followerSet.size() > topology.size() / 2) {
                    activateElection();
                }

                HeartbeatRequest.Builder builder = HeartbeatRequest.newBuilder();
                builder = builder.setLeaderModelIndex(0)
                        .setTerm(Node.getRuntimeNode().getTerm())
                        .setLeaderId(Node.getRuntimeNode().getSelfNodeInfo().getNodeId());

                // 构造请求中的时延列表
                synchronized (Node.getRuntimeNode().getTopology()) {
                    for (Map.Entry<Long, Integer> entry : topology.entrySet()) {
                        builder.addNodeIds(entry.getKey());
                        builder.addNetworkDelays(entry.getValue());
                    }
                }
                HeartbeatRequest request = builder.build();

                List<Long> clientList = request.getNodeIdsList();
                for (Long clientId : clientList) {
                    clientPool.getChannel(clientId).sendHeartBeat(request, new FedRaftClient.HeartbeatResponseHandler() {
                        @Override
                        public void handleResponse(HeartbeatResponse response) {
                            int networkDelay = response.getNetworkDelay();

                            // 更新心跳信息
                            if (networkDelay > 0) {
                                topology.computeIfPresent(clientId, (k, v) -> networkDelay);

                                // 统计存活follower数量
                                if (response.getNodeState() == NodeState.FOLLOWER) {
                                    followerSet.put(clientId, System.currentTimeMillis());
                                }
                            }
                        }
                    });
                }
            }
        }, 10, heartbeatInterval, TimeUnit.MILLISECONDS);
    }

    private void activateElection() {
    }

    @Override
    public void close() {
        // 停止心跳的发送
        if (heartbeatTask != null) {
            heartbeatTask.cancel(true);
        }
    }

    @Override
    public int receiveHeartbeat(HeartbeatRequest request) {

        return 0;
    }
}
