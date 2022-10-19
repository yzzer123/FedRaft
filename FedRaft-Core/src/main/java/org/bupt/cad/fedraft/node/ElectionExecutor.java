package org.bupt.cad.fedraft.node;


import org.bupt.cad.fedraft.beans.NodeInfo;
import org.bupt.cad.fedraft.rpc.message.VoteRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 维护选举时的状态信息
 */
public class ElectionExecutor {
    private static final Logger logger = LoggerFactory.getLogger(ElectionExecutor.class);
    private final AtomicInteger votesNum = new AtomicInteger(0);
    // 维护时延排行榜
    private List<Map.Entry<Long, Integer>> delayPriorityQueue;
    private Map<Long, Integer> topology;
    private Node nodeMode;
    // 允许投票的排名 时延名次<admittedIndex 可投票
    private int admittedIndex = 1;
    private boolean voted = false;

    public ElectionExecutor() {
        topology = Runtime.getRuntime().getTopology();
        delayPriorityQueue = new ArrayList<>(topology.size());
        reset();
    }

    //
    public void reset() {
        synchronized (this) {
            logger.info("reset election state");
            delayPriorityQueue.clear();
            synchronized (Runtime.getRuntime()) {
                nodeMode = Runtime.getRuntime().getNodeMode();
                synchronized (Runtime.getRuntime().getTopology()) {
                    delayPriorityQueue.addAll(topology.entrySet());
                }
            }
            delayPriorityQueue.sort(Comparator.comparingInt(Map.Entry::getValue));
            voted = false;
            admittedIndex++;
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
            if (voted) {
                return false;
            }
            // 检查任期/模型索引
            Runtime runtime = Runtime.getRuntime();
            synchronized (Runtime.getRuntime()) {
                if (runtime.getTerm() > request.getTerm() || runtime.getModelIndex() > request.getModelIndex()) {
                    return false;
                }


                for (int i = 0; i < admittedIndex; i++) {
                    if (delayPriorityQueue.get(i).getKey().equals(request.getCandidateId())) {
                        logger.info("vote for {}", new NodeInfo(request.getCandidateId()));
                        voted = true;
                        // 更新时延 表示支持这个candidate， 即使投票失败了，下一次也更有可能投给他
                        nodeMode.updateTopology(request.getNodeIdsList(), request.getNetworkDelaysList());
                        // 提升任期 但不更新模型索引
                        runtime.setTerm(request.getTerm());
                        return true;
                    }
                }
            }
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
            Runtime runtime = Runtime.getRuntime();
            for (int i = 0; i < admittedIndex; i++) {
                if (delayPriorityQueue.get(i).getKey().equals(runtime.getSelfNodeInfo().getNodeId())) {
                    logger.info("node itself can be a candidate!");
                    voted = true;
                    addVote();  // 将票投给自己
                    return true;
                }
            }
        }
        logger.warn("node itself is not qualified to be a candidate!");
        return false;
    }

    /**
     * 增加自己的票仓
     *
     * @return 增加后的票数
     */
    public int addVote() {
        return votesNum.incrementAndGet();
    }

}
