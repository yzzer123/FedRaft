package org.bupt.cad.fedraft.node.fedraft;


import org.bupt.cad.fedraft.beans.NodeInfo;
import org.bupt.cad.fedraft.beans.Tuple;
import org.bupt.cad.fedraft.config.Configuration;
import org.bupt.cad.fedraft.rpc.message.VoteRequest;
import org.bupt.cad.fedraft.utils.ElectionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Math.max;

/**
 * 维护选举时的状态信息
 */
public class ElectionExecutor {
    private static final Logger logger = LoggerFactory.getLogger(ElectionExecutor.class);

    // 统计自己接受到的票数
    private final AtomicInteger votesNum = new AtomicInteger(0);
    // 维护时延排行榜
    private final List<Tuple<Long, Integer>> delayPriorityQueue;
    private final Runtime runtime;
    // 允许投票的排名 时延名次<admittedIndex 可投票
    private int admittedIndex = Configuration.getInt(Configuration.ELECTION_CANDIDATE_QUALIFY_INDEX) + 1;
    private boolean voted = true;

    private ElectionListener listener;

    private int failedTimes = 0;


    public ElectionExecutor(Runtime runtime) {
        this.runtime = runtime;
        runtime.lockTopology(false);
        delayPriorityQueue = new ArrayList<>(runtime.getTopology().size());
        runtime.unlockTopology(false);
        reset();
    }

    /**
     * 重置投票状态，发生在投票超时，或者心跳超时中，<b>会增加自己的任期!</b>
     */
    public void reset() {
        synchronized (this) {
            logger.info("reset election state with term {}", runtime.getTerm());
            delayPriorityQueue.clear();

            runtime.lockTopology(false);
            for (Map.Entry<Long, Tuple<Integer, Long>> entry : runtime.getTopology().entrySet()) {
                delayPriorityQueue.add(new Tuple<>(entry.getKey(), entry.getValue().getLeft()));
            }
            runtime.unlockTopology(false);

            // 对时延进行排序
            delayPriorityQueue.sort(Comparator.comparingInt(Tuple::getRight));

            votesNum.set(0);

            //  如果上一次任期没投票，follower不能主动提升自己的任期
            if (voted) {
                runtime.lockRuntime(true);
                // 重置会增加任期
                runtime.addTerm();
                runtime.unlockRuntime(true);
                voted = false;
                failedTimes = 0;
            } else {
                failedTimes++;
                return;
            }
            // 最小减少到2
            admittedIndex = max(admittedIndex - 1, 2);
        }
    }

    /**
     * 作为follower检查能否投票，如果可以投票给他, 就投票
     *
     * @return 是否投票成功
     */
    public boolean voteFor(VoteRequest request) {
        synchronized (this) {

            if (logger.isDebugEnabled()) {
                logger.debug("get vote request from {}", new NodeInfo(request.getCandidateId()));
            }

            // 请求投票者的任期和模型索引不比自己高 并且本轮没有投票过
            if (runtime.getTerm() > request.getTerm() || runtime.getModelIndex() > request.getModelIndex() ||
                    (voted && runtime.getTerm() == request.getTerm())) {
                return false;
            }

            // 如果其任期已经高于本节点很多，说明本身自己保存的拓扑时效性已经过期
            if (runtime.getTerm() + Configuration.getInt(Configuration.ELECTION_FAIL_MAX_TERMS) <= request.getTerm()) {
                voteForOther(request);
                return true;
            }

            // 如果当前任期还没投票，或者出现更高任期，就开始检查资格
            for (int i = 0; i < admittedIndex; i++) {
                if (delayPriorityQueue.get(i).getLeft().equals(request.getCandidateId())) {
                    voteForOther(request);
                    return true;
                }
            }
        }
        return false;
    }


    private void voteForOther(VoteRequest request) {
        voted = true;

        // 更新时延 表示支持这个candidate， 即使投票失败了，下一次也更有可能投给他
        runtime.getNodeMode().updateTopology(request.getNodeIdsList(),
                request.getNetworkDelaysList(),
                System.currentTimeMillis());

        // 提升任期 但不更新模型索引
        runtime.setTerm(request.getTerm());
        votesNum.set(0);
        failedTimes = 0;
    }

    /**
     * 检查自己能否成为candidate
     *
     * @return 如果能够成为candidate就返回true
     */
    public boolean isQualifiedCandidate() {
        synchronized (this) {
            if (voted) {
                return false;
            }

            // 超过一定失败次数后，直接根据原生raft选举
            if (failedTimes > Configuration.getInt(Configuration.ELECTION_FAIL_MAX_TIMES)) {
                voteForSelf();
                return true;
            }

            for (int i = 0; i < admittedIndex; i++) {
                if (delayPriorityQueue.get(i).getLeft().equals(runtime.getSelfNodeInfo().getNodeId())) {
                    voteForSelf();
                    return true;
                }
            }
        }

        if (logger.isDebugEnabled()) {
            logger.debug("node itself is not qualified to be a candidate!");
        }
        return false;
    }

    private void voteForSelf() {
        if (logger.isDebugEnabled()) {
            logger.debug("node itself can be a candidate!");
        }
        voted = true;
        addVote();  // 将票投给自己

    }


    /**
     * 增加自己的票仓
     * 增加后的票数
     */
    public void addVote() {

        int votes = votesNum.incrementAndGet();

        synchronized (this) {
            if (listener != null) {
                runtime.lockTopology(false);

                if (votes > runtime.getTopology().size() / 2) {
                    listener.takeLeadership();
                    listener = null;
                }

                runtime.unlockTopology(false);
            }// end if
        }
    }

    /**
     * set listener for vote success
     *
     * @param listener election listener
     */
    public void setElectionListener(ElectionListener listener) {
        this.listener = listener;
    }
}
