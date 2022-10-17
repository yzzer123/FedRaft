package org.bupt.cad.fedraft.node;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bupt.cad.fedraft.rpc.message.HeartbeatRequest;
import org.bupt.cad.fedraft.rpc.message.NodeState;
import org.bupt.cad.fedraft.server.FedRaftServer;

import java.util.Map;

//SAFE_MODE
public class SafeMode implements NodeMode {

    private static final Logger logger = LogManager.getLogger(FedRaftServer.class.getName());


    public void checkinTmpLeader() {

        Node runtimeNode = Node.getRuntimeNode();
        runtimeNode.getZkClient().checkinTmpLeader(() -> {
            //争抢成功, 切换节点状态, 并唤醒tmp_leader
            runtimeNode.setState(NodeState.TMP_LEADER);
            runtimeNode.addTerm();
            logger.info("tmp leader is" + runtimeNode.getZkClient().getNodeName());
            runtimeNode.setState(NodeState.TMP_LEADER);
        });
    }

    //检查拓扑是否具有所有节点的时延
    public void checkTopologyDelay() {

        boolean isAllUpdated = true;
        for (Integer value : Node.getRuntimeNode().getTopology().values()) {
            if (value < 0) {
                isAllUpdated = false;
                break;
            }
        }
        if (isAllUpdated) {
            Node.getRuntimeNode().setState(NodeState.FOLLOWER);
        }
    }

    @Override
    public int receiveHeartbeat(HeartbeatRequest request) {

        // 获取运行时状态
        Node runtimeNode = Node.getRuntimeNode();

        // 同一时间只能有一个线程在修改节点状态

        // Safemode收到的心跳信息可能来自 tmp_leader 和 leader,
        if (request.getTerm() > runtimeNode.getTerm()) {
            // 跟随该leader 将任期提升
            runtimeNode.setTerm(request.getTerm())
                    .setLeader(request.getLeaderId());

        } else if (request.getTerm() < runtimeNode.getTerm()) {
            // 任期比自己小就为错误
            return -1;
        }

        // 更新自己的时延拓扑
        Map<Long, Integer> topology = Node.getRuntimeNode().getTopology();

        // 批量插入只能一个线程执行 ConcurrentHashMap只能保证单个操作原子
        synchronized (Node.getRuntimeNode().getTopology()) {
            int topologySize = request.getNodeIdsCount();
            topology.clear();
            for (int i = 0; i < topologySize; i++) {
                topology.put(request.getNodeIds(i), request.getNetworkDelays(i));
            }

            // 检查拓扑是否全部更新
            if (request.getTerm() > 0) {
                // 如果接收到的是leader的消息 直接变为follower
                runtimeNode.setState(NodeState.FOLLOWER);
            } else {
                checkTopologyDelay();
            }
        }

        return Node.getRuntimeNode().getDelay().get();
    }

    @Override
    public void close() {
        Node.getRuntimeNode().getZkClient().giveUpCheckinLeader();
    }
}
