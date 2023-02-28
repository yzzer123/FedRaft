package org.bupt.fedraft.job.manager;

import org.bupt.fedraft.server.ManagerClient;
import org.bupt.fedraft.state.ManagerState;
import org.bupt.fedraft.utils.TimerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Leader extends BaseJob {

    private static final Logger logger = LoggerFactory.getLogger(Leader.class);

    ScheduledFuture<?> scheduledFuture;

    public Leader(ManagerState managerState) {
        super(managerState);
        logger.info("manager become leader!!!");
        // 立刻进行两次同步，来保证尽快传播更新的时延拓扑
        ManagerClient.appendEntriesOnCluster(this);
        setupTimer();
    }

    @Override
    public void onAppendEntriesResponse(int term, int delay, long id) {
        getManagerState().updateRaftState(raftState -> {
            if (Leader.this != raftState.job) {
                return;
            }

            if (term > raftState.term) { // leader已经失效了
                this.closeTimer();
                raftState.job = new Follower(getManagerState());
                return;
            }

            getManagerState().updateTopology(id, delay);
        });

    }


    @Override
    protected void setupTimer() {
        scheduledFuture = TimerUtils.getTimer().scheduleAtFixedRate(() -> {
            ManagerClient.appendEntriesOnCluster(Leader.this);
        }, BASE_HEARTBEAT_TIMEOUT / 3, BASE_HEARTBEAT_TIMEOUT, TimeUnit.MILLISECONDS);
    }

    @Override
    protected void closeTimer() {
        if (logger.isDebugEnabled()) {
            logger.debug("leader close timeout task");
        }

        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            scheduledFuture = null;
        }
    }
}
