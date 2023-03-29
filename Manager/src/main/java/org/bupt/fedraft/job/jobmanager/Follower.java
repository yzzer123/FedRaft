package org.bupt.fedraft.job.jobmanager;

import org.bupt.fedraft.state.JobManager;
import org.bupt.fedraft.state.ManagerState;
import org.bupt.fedraft.state.VisitType;
import org.bupt.fedraft.utils.TimerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author yzzer
 */
public class Follower extends BaseJob {
    private static final Logger logger = LoggerFactory.getLogger(Follower.class);

    private ScheduledFuture<?> scheduledFuture;

    public Follower(JobManager manager, ManagerState managerState) {
        super(manager, managerState);
        logger.info("job:{} become follower", manager.uuid);
    }

    @Override
    public void setupTimer() {

        // 根据时延+心跳间隔+随机数计算超时时间
        long timeout = (long) ((Math.random() / 5 + 2) * BASE_HEARTBEAT_TIMEOUT
                + 2L * getManagerState().getDelay() / 1000L);

        if (logger.isDebugEnabled()) {
            logger.debug("follower setup timeout task with {} ms", timeout);
        }

        // 提交定时器
        scheduledFuture = TimerUtils.getTimer().schedule(() -> {
            getJobManager().visitRaftState(raftState -> {
                if (raftState.getJob() != Follower.this) {
                    return;
                }

                // 超时后判断自己能否成为候选人，否则就继续设置超时
                if (getManagerState().isQualifiedCandidate()) {
                    raftState.setJob(new Candidate(getJobManager(), getManagerState()));
                } else {
                    setupTimer();
                }
            }, VisitType.WRITE);
        }, timeout, TimeUnit.MILLISECONDS);
    }

    @Override
    public void closeTimer() {
        if (logger.isDebugEnabled()) {
            logger.debug("job follower close timeout task");
        }

        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            scheduledFuture = null;
        }
    }


}
