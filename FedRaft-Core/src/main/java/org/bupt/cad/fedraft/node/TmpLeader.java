package org.bupt.cad.fedraft.node;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bupt.cad.fedraft.beans.NodeInfo;
import org.bupt.cad.fedraft.server.FedRaftServer;
import org.bupt.cad.fedraft.utils.ZkClient;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class TmpLeader extends NodeMode {

    private static final Logger logger = LogManager.getLogger(FedRaftServer.class.getName());

    private AtomicInteger sum = new AtomicInteger(0);

    private final ConcurrentHashMap<Long, Integer> countTimes = new ConcurrentHashMap<>();

    //开始工作,计时器定时发送心跳连接
    public void init() {

        maintainHeartbeat();
        checkSum();
    }


    public boolean setClusterWatcher() {
        try {
            Node.getRuntimeNode().getZkClient().setClusterWatcher(new ZkClient.ClusterWatcher() {
                @Override
                public void addNode(NodeInfo nodeInfo) {
                    Node.getRuntimeNode().getTopologies().putIfAbsent(nodeInfo.getNodeId(), -1);
                }

                @Override
                public void removeNode(NodeInfo nodeInfo) {
                    Node.getRuntimeNode().getTopologies().remove(nodeInfo.getNodeId());
                }
            });
            return true;
        } catch (Exception e) {
//            e.printStackTrace();
            logger.error("设置监听器失败" + e.getMessage(), e);
        }
        return false;

    }

    private void maintainHeartbeat() {

        // TODO 改为单一计时器
        for (Long nodeId : Node.getRuntimeNode().getTopologies().keySet()) {

//            ScheduledFuture<?> scheduledFuture = Node.get.scheduleAtFixedRate(() -> {
//                FedRaftClient client = Node.clientChannels.get(nodeId);
//                client.sendHeartBeat(Node.term, Node.selfNodeInfo.getNodeId(), nodeId);
//
//            }, 0, 2000, TimeUnit.MILLISECONDS);

        }
    }

    public boolean count(Long clientId) {
//        countTimes.putIfAbsent(clientId, countTimes.getOrDefault(clientId, 0) + 1);
//        if(countTimes.get(clientId) >= 2){
//            sum.addAndGet(1);
//            return false;
//        }else{
//            return true;
//        }
        return false;
    }

    //每隔一段时间检查sum值是否大于一半的节点数
    private void checkSum() {
        if (sum.get() > Node.getRuntimeNode().getTopologies().size() / 2) {
            Node.getRuntimeNode().setState(NodeState.FOLLOWER);
            logger.info("开启选举 startElection");
        }
    }
}
