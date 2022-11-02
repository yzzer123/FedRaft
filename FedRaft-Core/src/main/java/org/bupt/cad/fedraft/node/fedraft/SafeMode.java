package org.bupt.cad.fedraft.node.fedraft;


import org.bupt.cad.fedraft.beans.Tuple;
import org.bupt.cad.fedraft.config.Configuration;
import org.bupt.cad.fedraft.rpc.message.HeartbeatRequest;
import org.bupt.cad.fedraft.rpc.message.NodeState;
import org.bupt.cad.fedraft.rpc.message.VoteRequest;
import org.bupt.cad.fedraft.utils.PingUtils;
import org.bupt.cad.fedraft.utils.TimeoutKeeper;
import org.bupt.cad.fedraft.utils.TimerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
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
public class SafeMode extends Node implements TimeoutKeeper {

    private static final Logger logger = LoggerFactory.getLogger(SafeMode.class);

    private ScheduledFuture<?> timeoutTask;

    private boolean hasReceivedHeartbeat = false;

    public SafeMode(Runtime runtime) {
        super(runtime);
        // 随机倒计时启动，给集群一定时间注册节点
        // 倒计时结束后主动触发超时事件抢占leader
        timeoutTask = TimerUtils.getTimer().schedule(this::heartbeatTimeout,
                Configuration.getInt(Configuration.ELECTION_TMP_LEADER_START_TIME) + new Random().nextInt(1000), TimeUnit.MILLISECONDS);

        if (logger.isDebugEnabled()){
            logger.debug("safemode initialized!!!");
        }
    }

    @Override
    public void heartbeatTimeout() {
        Runtime runtime = getRuntime();

        if (logger.isDebugEnabled()){
            logger.debug("trying to checkin tmp-leader");
        }

        if (runtime.getState() != NodeState.SAFE_MODE) {
            return;
        }

        runtime.getZkClient().checkinTmpLeader(() -> {
            //争抢成功, 切换节点状态, 并唤醒tmp_leader
            runtime.lockRuntime(true);
            runtime.setState(NodeState.TMP_LEADER);
            runtime.unlockRuntime(true);
            logger.info("tmp leader is {}", runtime.getSelfNodeInfo());
        });
    }

    // SafeMode的节点无法投票
    @Override
    public boolean voteFor(VoteRequest request) {
        return false;
    }

    /**
     * 超时抢占节点，监测到tmp leader心跳超时，自动抢占
     */
    @Override
    public void setupTimeoutTask() {
        timeoutTask = TimerUtils.getTimer().schedule(this::heartbeatTimeout,
                Configuration.getInt(Configuration.MANAGER_HEARTBEAT_TIME_INTERVAL) * 3L,
                TimeUnit.MILLISECONDS);
    }

    /**
     * 取消超时器
     */
    @Override
    public void cancelTimeoutTask() {
        if (timeoutTask != null) {

            if (logger.isDebugEnabled()){
                logger.debug("safemode 's timeout task canceled");
            }

            timeoutTask.cancel(true);
            timeoutTask = null;
        }
        // 如果原来在抢占，就要放弃
        getRuntime().getZkClient().giveUpCheckinLeader(false);
    }

    @Override
    public void resetTimeoutTask() {
        cancelTimeoutTask();
        setupTimeoutTask();
    }

    //检查拓扑是否具有所有节点的时延
    public void checkTopologyDelay() {
        boolean isAllUpdated = true;
        getRuntime().lockTopology(false);
        for (Tuple<Integer, Long> delayTuple : getRuntime().getTopology().values()) {
            if (delayTuple.getLeft() < 0) {
                isAllUpdated = false;
                break;
            }
        }
        getRuntime().unlockTopology(false);
        if (isAllUpdated) {
            getRuntime().setState(NodeState.FOLLOWER);
        }
    }

    @Override
    public int receiveHeartbeat(HeartbeatRequest request) {

        // 获取运行时状态
        Runtime runtime = getRuntime();

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
        updateTopology(request.getNodeIdsList(), request.getNetworkDelaysList(), request.getTimestamp());

        // 检查拓扑是否全部更新
        if (request.getLeaderState() == NodeState.LEADER) {
            // 如果接收到的是leader的消息 直接变为follower
            runtime.setState(NodeState.FOLLOWER);
        } else {
            resetTimeoutTask();
            checkTopologyDelay();
        }

        // 第一次回复心跳需要根据拓扑ping一下，否则第一次回复了无效的时延信息
        if (!hasReceivedHeartbeat) {
            hasReceivedHeartbeat = true;
            PingUtils.pingTopology(runtime);
        }

        return getRuntime().getDelay();
    }


    @Override
    public void close() {
        cancelTimeoutTask();
    }
}
