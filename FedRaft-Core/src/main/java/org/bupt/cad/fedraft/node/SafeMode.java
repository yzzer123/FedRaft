package org.bupt.cad.fedraft.node;


import org.bupt.cad.fedraft.rpc.message.HeartbeatRequest;
import org.bupt.cad.fedraft.rpc.message.NodeState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 安全模式的作用:
 * 1. 维护自身的全局拓扑状态直至最新
 * 2. 不参与选举过程，只接受来自leader或tmp_leader的心跳信息来维护全局拓扑
 * 3. 当tmp_leader发生宕机时，接替其工作
 * 4. 当时机适合时成为follower
 */
public class SafeMode extends Node {

    private static final Logger logger = LoggerFactory.getLogger(SafeMode.class);

    public void checkinTmpLeader() {

        Runtime runtime = Runtime.getRuntime();
        runtime.getZkClient().checkinTmpLeader(() -> {
            //争抢成功, 切换节点状态, 并唤醒tmp_leader
            runtime.setState(NodeState.TMP_LEADER);
            logger.info("tmp leader is {}", runtime.getZkClient().getNodeName());
        });
    }

    //检查拓扑是否具有所有节点的时延
    public void checkTopologyDelay() {
        boolean isAllUpdated = true;
        synchronized (Runtime.getRuntime().getTopology()) {
            for (Integer value : Runtime.getRuntime().getTopology().values()) {
                if (value < 0) {
                    isAllUpdated = false;
                    break;
                }
            }
        }
        if (isAllUpdated) {
            Runtime.getRuntime().setState(NodeState.FOLLOWER);
        }
    }

    @Override
    public int receiveHeartbeat(HeartbeatRequest request) {

        // 获取运行时状态
        Runtime runtime = Runtime.getRuntime();


        // Safemode收到的心跳信息可能来自 tmp_leader 和 leader,
        if (request.getTerm() > runtime.getTerm()) {
            // 跟随该leader 将任期提升
            runtime.setTerm(request.getTerm())
                    .setLeader(request.getLeaderId());

        } else if (request.getTerm() < runtime.getTerm()) {
            // 任期比自己小就为错误
            return -1;
        }

        // 更新自己的时延拓扑
        super.receiveHeartbeat(request);

        // 检查拓扑是否全部更新
        if (request.getTerm() > 0) {
            // 如果接收到的是leader的消息 直接变为follower
            runtime.setState(NodeState.FOLLOWER);
        } else {
            checkTopologyDelay();
        }

        return Runtime.getRuntime().getDelay().get();
    }

    @Override
    public void close() {
        if (isClosed()) {
            return;
        }
        if (Runtime.getRuntime().getState() == NodeState.FOLLOWER) {
            Runtime.getRuntime().getZkClient().giveUpCheckinLeader();
        }
        setClosed();
    }
}
