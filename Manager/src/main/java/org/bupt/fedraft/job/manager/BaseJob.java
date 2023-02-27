package org.bupt.fedraft.job.manager;

import org.bupt.fedraft.beans.NodeInfo;
import org.bupt.fedraft.beans.Tuple;
import org.bupt.fedraft.config.Configuration;
import org.bupt.fedraft.state.ManagerRaftState;
import org.bupt.fedraft.state.ManagerState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public abstract class BaseJob {

    public static final int BASE_HEARTBEAT_TIMEOUT = Configuration.getInt(Configuration.MANAGER_HEARTBEAT_TIME_INTERVAL);
    private static final Logger logger = LoggerFactory.getLogger(BaseJob.class);


    private final ManagerState managerState;

    public BaseJob(ManagerState managerState) {
        this.managerState = managerState;
        managerState.updateRaftState(raftState -> raftState.job = this);
    }


    public ManagerState getManagerState() {
        return managerState;
    }

    /**
     * 更新拓扑信息
     *
     * @param raftState  raft状态信息
     * @param term       请求方任期
     * @param leaderId   请求方ID
     * @param entryIndex 当前发送的日志索引
     * @param nodeIds    集群节点ID
     * @param delays     集群时延
     * @return 返回当前节点的任期
     */
    public Tuple<Integer, Integer> appendEntries(ManagerRaftState raftState, int term, long leaderId, long entryIndex, List<Long> nodeIds, List<Integer> delays) {
        if (raftState.job != this)
            return raftState.job.appendEntries(raftState, term, leaderId, entryIndex, nodeIds, delays);

        if (logger.isDebugEnabled()) {
            logger.debug("status: {}\t received a entry from leader:{} with term = {}, entryIndex = {} \nnodes = {} \ndelay = {}",
                    raftState, new NodeInfo(leaderId), term, entryIndex, nodeIds, delays);
        }

        // 任期检查
        if (term > raftState.term) {  // 任期较小时，leader和candidate都需要转换为follower
            raftState.term = term;
            raftState.voteFor = leaderId;
            raftState.entryIndex = entryIndex - 1;  // 当任期发生改变时，需要直接进行日志同步，消除错误拓扑

            if (logger.isDebugEnabled()) {
                logger.debug("term is out, following new leader with term = {}", term);
            }

            if (!(raftState.job instanceof Follower)) {
                raftState.job.closeTimer();
                raftState.job = new Follower(managerState);
            } else {// 当状态没有发生改变时，重置计时器即可
                raftState.job.resetTimer();
            }
        } else if (term < raftState.term || entryIndex <= raftState.entryIndex) {        // 任期大于接收到的任期或日志索引不合法就直接返回自己的任期

            if (logger.isDebugEnabled()) {
                logger.debug("request is invalid with term = {} - local term = {}, entryIndex = {} - localEntryIndex = {}", term, raftState.term, entryIndex, raftState.entryIndex);
            }

            return new Tuple<>(term, getManagerState().getDelay());
        } else {// 可以正常更新拓扑就更新计时器
            raftState.job.resetTimer();
        }


        managerState.updateTopology(topology -> {
            topology.clear();
            int size = nodeIds.size();
            for (int i = 0; i < size; i++) {
                topology.add(new Tuple<>(nodeIds.get(i), delays.get(i)));
            }

            if (logger.isDebugEnabled()) {
                logger.debug("topology updated = {}", topology);
            }
        });

        raftState.entryIndex = entryIndex;
        return new Tuple<>(term, getManagerState().getDelay());
    }

    /**
     * 接受到投票
     *
     * @param raftState   raft算法保存的状态信息
     * @param term        请求方任期
     * @param candidateId 请求方ID
     * @param entryIndex  请求方最新日志索引
     * @return 返回是否投票给他
     */
    public Tuple<Boolean, Integer> voteFor(ManagerRaftState raftState, int term, long candidateId, long entryIndex) {
        if (raftState.job != this) return raftState.job.voteFor(raftState, term, candidateId, entryIndex);
        if (logger.isDebugEnabled()) {
            logger.debug("status: {} received a vote request from {} term = {}, entryIndex = {}",
                    raftState, new NodeInfo(candidateId), term, entryIndex);
        }


        // 任期检查
        if (term < raftState.term) {        // 任期较大时直接拒绝投票
            if (logger.isDebugEnabled()) {
                logger.debug("candidate's term is out， refuse to vote");
            }

            return new Tuple<>(false, raftState.term);
        }

        if (term > raftState.term && entryIndex >= raftState.entryIndex) { // 本地任期较小，就提升任期，重置投票状态
            raftState.term = term;
            raftState.voteFor = -1;

            if (logger.isDebugEnabled()) {
                logger.debug("updated term = {}, ready for vote", term);
            }

            if (!(raftState.job instanceof Follower)) {
                raftState.job.closeTimer();
                raftState.job = new Follower(managerState);
            }
        } else if (entryIndex < raftState.entryIndex) {

            if (logger.isDebugEnabled()) {
                logger.debug("candidate's entryIndex is out， refuse to vote");
            }
            return new Tuple<>(false, raftState.term);
        }

        if (raftState.voteFor == -1 || raftState.voteFor == candidateId) {  // 如果自己还没投票，就投票给候选人
            raftState.voteFor = candidateId;
            raftState.job.resetTimer();
            if (logger.isDebugEnabled()) {
                logger.debug("vote for candidate = {}", new NodeInfo(candidateId));
            }
            return new Tuple<>(true, raftState.term);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("already voted for {} , refuse to vote again", new NodeInfo(raftState.voteFor));
        }
        return new Tuple<>(false, raftState.term);
    }

    public void submitJob(ManagerRaftState raftState) {
        if (raftState.job != this) raftState.job.submitJob(raftState);

    }

    public void onAppendEntriesResponse(int term, int delay, long id) {

    }

    public void onVoteResponse(boolean voteGranted, int term) {

    }

    /**
     * 启动倒计时任务
     */
    protected void setupTimer() {

    }

    /**
     * 关闭倒计时任务
     */
    protected void closeTimer() {

    }

    /**
     * 重置倒计时任务
     */
    public void resetTimer() {
        closeTimer();
        setupTimer();
    }
}
