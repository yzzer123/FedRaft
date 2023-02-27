package org.bupt.cad.fedraft.node.fedraft;

import org.bupt.cad.fedraft.beans.NodeInfo;
import org.bupt.cad.fedraft.beans.Tuple;
import org.bupt.cad.fedraft.rpc.message.HeartbeatRequest;
import org.bupt.cad.fedraft.rpc.message.NodeState;
import org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest;
import org.bupt.cad.fedraft.rpc.message.VoteRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;


/**
 * 维护各个节点状态共有的行为
 */
public abstract class Node {


    private static final Logger logger = LoggerFactory.getLogger(Node.class);

    private long heartbeatTimestamp = System.currentTimeMillis();

    private final Runtime runtime;

    public Node(Runtime runtime) {
        this.runtime = runtime;
    }

    // TODO 不够安全，follower恶意触发重新选举
    public void triggerElection(TriggerElectionRequest request) {


        // 触发操作时
        runtime.lockRuntime(true);

        // 当任期小的节点请求重新选举就忽略请求
        if (runtime.getState() != NodeState.FOLLOWER || request.getTerm() < runtime.getTerm()) {
            runtime.unlockRuntime(true);
            return;
        }

        // 激活选举流程
        logger.info("{} trigger timeout to re-election", new NodeInfo(request.getLeaderId()));

        // 只有follower才能被激活进入选举，leader必须放弃主权
        if (runtime.getState() != NodeState.FOLLOWER) {
            runtime.setState(NodeState.FOLLOWER);
        }

        // 取消倒计时任务
        runtime.getNodeMode().close();

        runtime.unlockRuntime(true);
        runtime.getNodeMode().heartbeatTimeout();
    }


    /**
     * 收到心跳信息 更新节点拓扑
     */
    public abstract int receiveHeartbeat(HeartbeatRequest request);


    // 外层使用时一般会加锁
    public void updateTopology(List<Long> nodeIds, List<Integer> delays, long heartbeatTimestamp) {

        // 更新自己的时延拓扑
        Map<Long, Tuple<Integer, Long>> topology = runtime.getTopology();

        if (heartbeatTimestamp > this.heartbeatTimestamp) {
            this.heartbeatTimestamp = heartbeatTimestamp;
        } else {
            return;
        }

        // 对于集群变更，只能增加不能减少
        runtime.lockTopology(true);

        for (int i = 0; i < nodeIds.size(); i++) {
            int delay = delays.get(i);
            topology.compute(nodeIds.get(i), (k, oldPair) -> {
                if (oldPair == null) {
                    oldPair = new Tuple<>(delay, heartbeatTimestamp);
                } else {
                    oldPair.setTuple(delay, heartbeatTimestamp);
                }
                return oldPair;
            });
        }
        if (logger.isDebugEnabled()) {
            logger.debug("updated local topology = {}", topology);
        }
        runtime.unlockTopology(true);
    }


    /**
     * 心跳超时的处理
     */
    public void heartbeatTimeout() {

    }

    public Runtime getRuntime() {
        return runtime;
    }

    public abstract boolean voteFor(VoteRequest request);

    /**
     * 退出原来的模式时要做的善后工作
     */
    abstract void close();

}
