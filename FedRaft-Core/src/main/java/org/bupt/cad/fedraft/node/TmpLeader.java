package org.bupt.cad.fedraft.node;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bupt.cad.fedraft.beans.NodeInfo;
import org.bupt.cad.fedraft.rpc.message.HeartbeatRequest;
import org.bupt.cad.fedraft.server.FedRaftClient;
import org.bupt.cad.fedraft.server.FedRaftServer;
import org.bupt.cad.fedraft.utils.ZkClient;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class TmpLeader implements NodeMode {

    private static final Logger logger = LogManager.getLogger(FedRaftServer.class.getName());

    private AtomicInteger sum = new AtomicInteger(0);

    private final ConcurrentHashMap<Long, Integer> countTimes = new ConcurrentHashMap<>();

    public TmpLeader() {
        Node.getRuntimeNode().addTerm();
    }

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
                    Node.getRuntimeNode().getTopology().putIfAbsent(nodeInfo.getNodeId(), -1);
                }

                @Override
                public void removeNode(NodeInfo nodeInfo) {
                    Node.getRuntimeNode().getTopology().remove(nodeInfo.getNodeId());
                    // 如果有通信通道就删除
                    FedRaftClient removedClient = Node.getRuntimeNode().getClientPool().removeChannel(nodeInfo.getNodeId());
                    if (removedClient != null) {
                        removedClient.close();
                    }
                }

                @Override
                public void initNodes(List<NodeInfo> nodeInfos) {

                }
            });
            return true;
        } catch (Exception e) {
//            e.printStackTrace();
            logger.error("设置监听器失败" + e.getMessage(), e);
        }
        return false;

    }

    // TODO 开启定时发送心跳任务
    private void maintainHeartbeat() {

    }

    public boolean count(Long clientId) {

        return false;
    }

    //每隔一段时间检查sum值是否大于一半的节点数
    private void checkSum() {
        if (sum.get() > Node.getRuntimeNode().getTopology().size() / 2) {
            Node.getRuntimeNode().setState(NodeState.FOLLOWER);
            logger.info("开启选举 startElection");
        }
    }

    @Override
    public int receiveHeartbeat(HeartbeatRequest request) {
        return 0;
    }
}
