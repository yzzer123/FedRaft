package org.bupt.fedraft.job.manager;

import org.bupt.fedraft.server.ManagerClient;
import org.bupt.fedraft.state.ManagerState;
import org.bupt.fedraft.utils.TimerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Candidate extends BaseJob {

    private static final Logger logger = LoggerFactory.getLogger(Candidate.class);
    private ScheduledFuture<?> scheduledFuture;

    private int voteCount = 0;
    private int clusterSize = 0;


    public Candidate(ManagerState managerState) {
        super(managerState);
        logger.info("manager become candidate!");
        requestVote();
    }

    private void requestVote() {
        long selfId = getManagerState().getSelfNodeInfo().getNodeId();
        getManagerState().updateRaftState(raftState -> {

            if (raftState.job != Candidate.this) {
                return;
            }
            raftState.term++;
            raftState.voteFor = selfId;
            voteCount = 1;
//            logger.info("candidate add term and begin to elect");
            clusterSize = ManagerClient.voteForOnCluster(this);

            resetTimer();
        });

    }

    @Override
    public void onVoteResponse(boolean voteGranted, int term) {
        getManagerState().updateRaftState(raftState -> {

            if (logger.isDebugEnabled()) {
                logger.debug("candidate[status: {}]  received vote response with granted={}, term={}"
                        , Candidate.this, voteGranted, term);
            }

            // 判断顺序不能改变
            if (raftState.job != Candidate.this) {
                if (logger.isDebugEnabled()) {
                    logger.debug("job changed, vote response is invalid ");
                }
                return;
            }

            if (term > raftState.term) {  // 说明已经有更高任期的leader或candidate，直接转变为follower
                if (logger.isDebugEnabled()) {
                    logger.debug("leader with higher term = {} appeared, change to follower", term);
                }
                this.closeTimer();
                raftState.job = new Follower(getManagerState());
                return;
            }

            if (voteGranted) {  // 检查是否投票给自己

                voteCount++;
                if (logger.isDebugEnabled()) {
                    logger.debug("candidate get one vote, new status: {}", Candidate.this);
                }
                if (voteCount > clusterSize / 2) {
                    this.closeTimer();
                    raftState.job = new Leader(getManagerState());
                }
            }
        });
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "voteCount=" + voteCount +
                ", clusterSize=" + clusterSize +
                '}';
    }

    @Override
    protected void setupTimer() {

        long timeout = (long) ((Math.random() + 1) / 2 * BASE_HEARTBEAT_TIMEOUT);

        if (logger.isDebugEnabled()) {
            logger.debug("candidate setup timeout task with {} ms", timeout);
        }

        scheduledFuture = TimerUtils.getTimer().schedule(this::requestVote,
                timeout, TimeUnit.MILLISECONDS);
    }


    @Override
    protected void closeTimer() {

        if (logger.isDebugEnabled()) {
            logger.debug("candidate close timeout task");
        }

        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            scheduledFuture = null;
        }
    }
}
