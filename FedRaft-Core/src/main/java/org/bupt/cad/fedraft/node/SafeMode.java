package org.bupt.cad.fedraft.node;


import org.bupt.cad.fedraft.config.Configuration;
import org.bupt.cad.fedraft.rpc.message.HeartbeatRequest;
import org.bupt.cad.fedraft.rpc.message.NodeState;
import org.bupt.cad.fedraft.utils.TimerUtils;
import org.bupt.cad.fedraft.utils.ZkClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * 安全模式的作用:
 * 1. 维护自身的全局拓扑状态直至最新
 * 2. 不参与选举过程，只接受来自leader或tmp_leader的心跳信息来维护全局拓扑
 * 3. 当tmp_leader发生宕机时，接替其工作
 * 4. 当时机适合时成为follower
 * 5. 设定超时器，超时抢占tmp leader, 接收到心跳时
 */
public class SafeMode extends Node {

    private static final Logger logger = LoggerFactory.getLogger(SafeMode.class);

    private final ZkClient zkClient;
    private ScheduledFuture<?> timeoutTask;

    public SafeMode() {
        zkClient = Runtime.getRuntime().getZkClient();
        // 启动时抢占leader
        checkinTmpLeader();
    }

    private void checkinTmpLeader() {
        Runtime runtime = Runtime.getRuntime();

        zkClient.checkinTmpLeader(() -> {
            //争抢成功, 切换节点状态, 并唤醒tmp_leader
            synchronized (Runtime.getRuntime()) {
                runtime.setState(NodeState.TMP_LEADER);
            }
            logger.info("tmp leader is {}", zkClient.getNodeName());
        });
    }

    /**
     * 超时抢占节点，监测到tmp leader心跳超时，自动抢占
     */
    private void setupTimeoutTask() {
        timeoutTask = TimerUtils.getTimer().schedule(this::checkinTmpLeader,
                Configuration.getInt(Configuration.NODE_HEARTBEAT_TIME_INTERVAL) * 3L,
                TimeUnit.MILLISECONDS);
    }

    /**
     * 取消超时器
     */
    private void cancelTimeoutTask() {
        if (timeoutTask != null) {
            timeoutTask.cancel(true);
            timeoutTask = null;
        }
        // 如果原来在抢占，就要放弃
        zkClient.giveUpCheckinLeader();
    }

    private void resetTimeoutTask() {
        cancelTimeoutTask();
        setupTimeoutTask();
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
        updateTopology(request.getNodeIdsList(), request.getNetworkDelaysList());

        // 检查拓扑是否全部更新
        if (request.getLeaderState() == NodeState.LEADER) {
            // 如果接收到的是leader的消息 直接变为follower
            runtime.setState(NodeState.FOLLOWER);
        } else {
            resetTimeoutTask();
            checkTopologyDelay();
        }

        return Runtime.getRuntime().getDelay().get();
    }

    @Override
    public void close() {
        if (isClosed()) {
            return;
        }
        cancelTimeoutTask();
        setClosed();
    }
}
