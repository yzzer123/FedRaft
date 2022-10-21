package org.bupt.cad.fedraft.node;

import org.bupt.cad.fedraft.beans.NodeInfo;
import org.bupt.cad.fedraft.beans.Tuple;
import org.bupt.cad.fedraft.rpc.message.HeartbeatRequest;
import org.bupt.cad.fedraft.rpc.message.NodeState;
import org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest;
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


    public static void triggerElection(TriggerElectionRequest request) {

        Runtime runtime = Runtime.getRuntime();

        // 当任期小的节点请求重新选举就忽略请求
        if (runtime.getState() != NodeState.FOLLOWER || request.getTerm() < Runtime.getRuntime().getTerm()) {
            return;
        }

        // 取消倒计时任务

        // 激活选举流程
        logger.info("{} trigger timeout to re-election", new NodeInfo(request.getLeaderId()));
        election();
    }

    /**
     * 选举逻辑，判断自己能否成为candidate, 否则就保持follower， leader必须放弃主权
     */
    public static void election() {
        logger.info("enter election mode");
    }


    /**
     * 收到心跳信息 更新节点拓扑
     */
    public abstract int receiveHeartbeat(HeartbeatRequest request);

    public void updateTopology(List<Long> nodeIds, List<Integer> delays, long heartbeatTimestamp) {

        // 更新自己的时延拓扑
        Map<Long, Tuple<Integer, Long>> topology = Runtime.getRuntime().getTopology();

        if (heartbeatTimestamp > this.heartbeatTimestamp){
            this.heartbeatTimestamp = heartbeatTimestamp;
        }else {
            return;
        }


        // 批量插入只能一个线程执行 ConcurrentHashMap只能保证单个操作原子

        // 对于集群变更，只能增加不能减少
        synchronized (Runtime.getRuntime().getTopology()) {
            for (int i = 0; i < nodeIds.size(); i++) {
                int delay = delays.get(i);
                topology.compute(nodeIds.get(i), (k, oldPair) -> {
                    if (oldPair == null){
                        oldPair = new Tuple<>(delay, heartbeatTimestamp);
                    }else{
                        oldPair.setTuple(delay, heartbeatTimestamp);
                    }
                    return oldPair;
                });
            }
            if (logger.isDebugEnabled()) {
                logger.debug("updated local topology = {}", topology);
            }
        }
    }


    /**
     * 心跳超时的处理
     */
    public void heartbeatTimeout() {

    }

    /**
     * 退出原来的模式时要做的善后工作
     */
    abstract void close();

}
