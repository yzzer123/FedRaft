package org.bupt.cad.fedraft.node.fedraft;

import org.bupt.cad.fedraft.beans.Tuple;
import org.bupt.cad.fedraft.config.Configuration;
import org.bupt.cad.fedraft.rpc.message.HeartbeatRequest;
import org.bupt.cad.fedraft.rpc.message.NodeState;
import org.bupt.cad.fedraft.rpc.message.VoteRequest;
import org.bupt.cad.fedraft.utils.ClientPool;
import org.bupt.cad.fedraft.utils.TimeoutKeeper;
import org.bupt.cad.fedraft.utils.TimerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;


/**
 * candidate 职能
 * 请求投票
 * 选举超时，检查自己是否还有资格继续保持candidate， 否则就转换为follower，重置选举状态
 * 接收到更高任期心跳，就转换为follower跟随
 * 向其他节点发起投票请求，统计接收到的投票， 请求投票时会顺带发送全局拓扑
 */
public class Candidate extends Node implements TimeoutKeeper {
    private static final Logger logger = LoggerFactory.getLogger(Candidate.class);

    private ElectionExecutor electionState;

    private ScheduledFuture<?> timeoutTask;

    public Candidate(Runtime runtime, ElectionExecutor electionState) {
        super(runtime);
        this.electionState = electionState;
        this.electionState.setElectionListener(() -> {
            getRuntime().lockRuntime(true);
            getRuntime().setState(NodeState.LEADER);
            getRuntime().unlockRuntime(true);
        });

        // 请求投票
//        getRuntime().lockRuntime(true);
//        getRuntime().addTerm();
//        getRuntime().unlockRuntime(true);

        requestForVote();
        setupTimeoutTask();

        if (logger.isDebugEnabled()){
            logger.debug("change to candidate!!");
        }
    }

    @Override
    public void resetTimeoutTask() {
        cancelTimeoutTask();
        setupTimeoutTask();
    }

    @Override
    public void setupTimeoutTask() {
        timeoutTask = TimerUtils.getTimer().schedule(this::electionTimeout,
                Configuration.getInt(Configuration.ELECTION_CANDIDATE_TIMEOUT),
                TimeUnit.MILLISECONDS);
    }

    @Override
    public void cancelTimeoutTask() {
        if (timeoutTask != null) {
            timeoutTask.cancel(true);
            timeoutTask = null;
        }
    }

    public void electionTimeout() {
        
        electionState.reset();
        if (electionState.isQualifiedCandidate()) {
            // 发生投票
            requestForVote();
            resetTimeoutTask();
        } else {

            // 如果自己无法再成为candidate，就重新回到follower
            getRuntime().lockRuntime(true);

            getRuntime().setState(NodeState.FOLLOWER);
            getRuntime().<Follower>getNodeMode().setElectionExecutor(electionState);

            getRuntime().unlockRuntime(true);

        }


    }

    public ElectionExecutor getElectionExecutor() {
        return electionState;
    }

    public void setElectionExecutor(ElectionExecutor electionState) {
        this.electionState = electionState;
    }

    /**
     * 请求投票
     */
    public void requestForVote() {

        if (logger.isDebugEnabled()) {
            logger.debug("candidate request for vote!");
        }
        Map<Long, Tuple<Integer, Long>> topology = getRuntime().getTopology();

        // 构造请求
        VoteRequest.Builder voteRequestBuilder = VoteRequest.newBuilder();
        getRuntime().lockRuntime(false);

        voteRequestBuilder.setCandidateId(getRuntime().getSelfNodeInfo().getNodeId())
                .setModelIndex(getRuntime().getModelIndex())
                .setTerm(getRuntime().getTerm());

        getRuntime().unlockRuntime(false);

        // 构造时延拓扑
        getRuntime().lockTopology(false);

        for (Map.Entry<Long, Tuple<Integer, Long>> delayEntry : topology.entrySet()) {
            voteRequestBuilder.addNodeIds(delayEntry.getKey());
            voteRequestBuilder.addNetworkDelays(delayEntry.getValue().getLeft());
        }
        getRuntime().unlockTopology(false);

        VoteRequest voteRequest = voteRequestBuilder.build();
        ClientPool clientPool = getRuntime().getClientPool();
        ExecutorService threadPool = getRuntime().getThreadPool();

        long selfId = getRuntime().getSelfNodeInfo().getNodeId();
        for (Long clientId : voteRequest.getNodeIdsList()) {
            if (clientId.equals(selfId)){
                continue;
            }
            threadPool.submit(() -> clientPool.getChannel(clientId).requestForVote(voteRequest, electionState));
        }
    }

    @Override
    public int receiveHeartbeat(HeartbeatRequest request) {

        // 对于tmp_leader的心跳，直接返回
        if (request.getLeaderState() == NodeState.TMP_LEADER) {
            return getRuntime().getDelay();
        }


        if (request.getTerm() >= getRuntime().getTerm()) {
            // 跟随该leader 将任期提升
            getRuntime().setTerm(request.getTerm())
                    .setLeader(request.getLeaderId());
            getRuntime().setState(NodeState.FOLLOWER);  // 直接转变为follower

            // 更新拓扑
            updateTopology(request.getNodeIdsList(), request.getNetworkDelaysList(), request.getTimestamp());
            return getRuntime().getDelay();
        }

        return -1;
    }

    @Override
    public boolean voteFor(VoteRequest request) {
        if (request.getTerm() > getRuntime().getTerm()) {
            if (logger.isDebugEnabled()) {
                logger.debug("candidate received a higher term vote request, become a follower to vote!");
            }

            getRuntime().setState(NodeState.FOLLOWER);
            return getRuntime().<Follower>getNodeMode().voteFor(request);
        }
        return false;
    }

    @Override
    public void close() {
        cancelTimeoutTask();
    }
}
