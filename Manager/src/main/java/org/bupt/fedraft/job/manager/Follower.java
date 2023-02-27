package org.bupt.fedraft.job.manager;

import org.bupt.fedraft.state.ManagerState;
import org.bupt.fedraft.utils.TimerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Follower extends BaseJob {

    private static final Logger logger = LoggerFactory.getLogger(Follower.class);

    private ScheduledFuture<?> scheduledFuture;

    public Follower(ManagerState managerState) {
        this(managerState, false);
    }


    public Follower(ManagerState managerState, boolean waiting) {
        super(managerState);
        if (!waiting) {
            setupTimer();
        }
        logger.info("manager become follower!");
    }

    @Override
    protected void setupTimer() {
        long timeout = (long) ((Math.random() + 2) * BASE_HEARTBEAT_TIMEOUT);

        if (logger.isDebugEnabled()) {
            logger.debug("follower setup timeout task with {} ms", timeout);
        }

        // 提交定时器
        scheduledFuture = TimerUtils.getTimer().schedule(() -> {
            // 超时后就将自己设置为候选人
            getManagerState().updateRaftState(raftState -> {
                // 检查是否当前状态已经发生改变
                if (raftState.job != Follower.this) return;
                Follower.this.closeTimer();
                raftState.job = new Candidate(getManagerState());
            });
        }, timeout, TimeUnit.MILLISECONDS);
    }


    @Override
    protected void closeTimer() {

        if (logger.isDebugEnabled()) {
            logger.debug("follower close timeout task");
        }

        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            scheduledFuture = null;
        }
    }
}
