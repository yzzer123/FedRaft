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
    private boolean voted = false;

    private ElectionListener listener;


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
            logger.info("reset election state");
            delayPriorityQueue.clear();

            runtime.lockRuntime(true);
            // 重置会增加任期
            runtime.addTerm();
            runtime.unlockRuntime(true);


            runtime.lockTopology(false);

            for (Map.Entry<Long, Tuple<Integer, Long>> entry : runtime.getTopology().entrySet()) {
                delayPriorityQueue.add(new Tuple<>(entry.getKey(), entry.getValue().getLeft()));
            }

            runtime.unlockRuntime(false);

            // 对时延进行排序
            delayPriorityQueue.sort(Comparator.comparingInt(Tuple::getRight));
            voted = false;

            // 最小减少到1
            admittedIndex = max(admittedIndex - 1, 1);
            votesNum.set(0);

        }
    }

    /**
     * 作为follower检查能否投票，如果可以投票给他, 就投票
     *
     * @return 是否投票成功
     */
    public boolean voteFor(VoteRequest request) {
        synchronized (this) {

            // 检查任期/模型索引

            runtime.lockRuntime(true);

            // 请求投票者的任期和模型索引不比自己高
            if (runtime.getTerm() > request.getTerm() || runtime.getModelIndex() > request.getModelIndex() ||
                    (voted && runtime.getTerm() == request.getTerm())) {
                runtime.unlockRuntime(true);
                return false;
            }

            // 如果当前任期还没投票，或者出现更高任期，就开始检查资格
            for (int i = 0; i < admittedIndex; i++) {
                if (delayPriorityQueue.get(i).getLeft().equals(request.getCandidateId())) {
                    logger.info("vote for {}", new NodeInfo(request.getCandidateId()));
                    voted = true;
                    // 更新时延 表示支持这个candidate， 即使投票失败了，下一次也更有可能投给他
                    runtime.getNodeMode().updateTopology(request.getNodeIdsList(),
                            request.getNetworkDelaysList(),
                            System.currentTimeMillis());

                    // 提升任期 但不更新模型索引
                    runtime.setTerm(request.getTerm());
                    votesNum.set(0);
                    return true;
                }
            }

            runtime.unlockRuntime(true);
        }
        return false;
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
            for (int i = 0; i < admittedIndex; i++) {
                if (delayPriorityQueue.get(i).getLeft().equals(runtime.getSelfNodeInfo().getNodeId())) {
                    if (logger.isDebugEnabled()) {
                        logger.debug("node itself can be a candidate!");
                    }
                    voted = true;
                    addVote();  // 将票投给自己
                    return true;
                }
            }
        }

        // 可以成为一个leader
        if (logger.isDebugEnabled()) {
            logger.debug("node itself is not qualified to be a candidate!");
        }
        return false;
    }

    /**
     * 增加自己的票仓
     * 增加后的票数
     */
    public void addVote() {
        int votes = votesNum.incrementAndGet();
        if (listener != null) {
            runtime.lockTopology(false);

            if (votes > runtime.getTopology().size() / 2) {
                listener.takeLeadership();
            }

            runtime.unlockTopology(false);
        }// end if
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
