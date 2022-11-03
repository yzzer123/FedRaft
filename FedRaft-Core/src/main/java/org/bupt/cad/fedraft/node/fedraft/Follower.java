package org.bupt.cad.fedraft.node.fedraft;

import org.bupt.cad.fedraft.config.Configuration;
import org.bupt.cad.fedraft.rpc.message.HeartbeatRequest;
import org.bupt.cad.fedraft.rpc.message.NodeState;
import org.bupt.cad.fedraft.rpc.message.VoteRequest;
import org.bupt.cad.fedraft.utils.TimeoutKeeper;
import org.bupt.cad.fedraft.utils.TimerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;


/**
 * follower的功能：
 * 1. 通过心跳和leader同步时延 和 SAFE_MODE类似
 * 2. 当接收到任期大的leader时，更改追随目标， TODO 如果模型索引更新，trainer 感知后会主动拉取新的模型
 * 3. 设置超时器， 当心跳超时时触发选举，  如果能够成为Candidate 就转换状态请求其他节点投票
 * 4. 当接受到心跳时，重置超时器
 * 5. (在ElectionExecutor中实现)当收到投票请求时，检查请求者是否合法(任期，时延大小2th，模型索引)，提升自己的任期， 记录投票状态，一个任期内只能投给其中一个leader
 * 6. 维护一个选举状态，当收到新leader的心跳之后就可以删除选举状态
 */
public class Follower extends Node implements TimeoutKeeper {

    private static final Logger logger = LoggerFactory.getLogger(Follower.class);

    private ElectionExecutor electionExecutor;

    private ScheduledFuture<?> timeoutTask;

    public Follower(Runtime runtime) {
        super(runtime);
        setupTimeoutTask();
    }


    /**
     * 超时触发选举
     */
    @Override
    public void setupTimeoutTask() {
        timeoutTask = TimerUtils.getTimer().schedule(this::heartbeatTimeout,
                Configuration.getInt(Configuration.MANAGER_HEARTBEAT_TIME_INTERVAL) * 2L +
                        getRuntime().getDelay() / 1000 * 3,
                TimeUnit.MILLISECONDS);
    }

    /**
     * 删除超时器
     */
    @Override
    public void cancelTimeoutTask() {
        if (timeoutTask != null) {
            timeoutTask.cancel(true);
            timeoutTask = null;
        }
    }

    /**
     * 重置超时器
     */
    @Override
    public void resetTimeoutTask() {
        if (logger.isDebugEnabled()) {
            logger.debug("follower reset timout task");
        }
        cancelTimeoutTask();
        setupTimeoutTask();
    }

    @Override
    public int receiveHeartbeat(HeartbeatRequest request) {

        // 获取运行时状态
        Runtime runtime = getRuntime();


        // 在选举期间收到tmp leader心跳 直接忽略
        if (electionExecutor != null && request.getLeaderState() == NodeState.TMP_LEADER) {
            return getRuntime().getDelay();
        }

        // follower收到的心跳信息可能来自 tmp_leader 和 leader,
        if (request.getTerm() > runtime.getTerm()) {
            // 跟随该leader 将任期提升
            runtime.setTerm(request.getTerm())
                    .setLeader(request.getLeaderId());

        } else if (request.getTerm() < runtime.getTerm() && runtime.getLeaderInfo() != null) {
            // 任期比自己小就为错误
            return request.getLeaderState() == NodeState.TMP_LEADER ? getRuntime().getDelay() : -1;
        }

        resetTimeoutTask();
        // 更新自己的时延拓扑
        updateTopology(request.getNodeIdsList(), request.getNetworkDelaysList(), request.getTimestamp());

        // 通知trainer拉取模型
        if (request.getLeaderModelIndex() > runtime.getModelIndex()) {
            // notify trainer pull model
        }

        // 如果在选举状态中，就删除之前的选举状态
        electionExecutor = null;

        return getRuntime().getDelay();
    }

    /**
     * 超时触发选举
     */
    @Override
    public void heartbeatTimeout() {

        if (logger.isDebugEnabled()){
            logger.debug("follower trigger heartbeat timeout task");
        }

        // 如果之前没有出现选举失败 就开启新的选举状态
        if (electionExecutor == null) {
            electionExecutor = new ElectionExecutor(getRuntime());
        } else {
            // 有选举状态，就说明之前成为candidate失败, 即投票太过分散 需要将投票门槛设高，使得投票更加集中
            electionExecutor.reset();
        }
        getRuntime().lockRuntime(true);
        getRuntime().setLeader(null);
        if (electionExecutor.isQualifiedCandidate()) {
            getRuntime().setState(NodeState.CANDIDATE);
        } else {
            // 否则重置选举超时任务
            resetTimeoutTask();
        }
        getRuntime().unlockRuntime(true);
    }

    @Override
    public boolean voteFor(VoteRequest request) {
        if (electionExecutor == null && request.getTerm() > getRuntime().getTerm()) {
            electionExecutor = new ElectionExecutor(getRuntime());
        }
        this.resetTimeoutTask();

        return electionExecutor != null && electionExecutor.voteFor(request);
    }


    public ElectionExecutor getElectionExecutor() {
        return electionExecutor;
    }

    public void setElectionExecutor(ElectionExecutor electionState){
        electionExecutor = electionState;
    }


    @Override
    public void close() {
        cancelTimeoutTask();
    }
}
