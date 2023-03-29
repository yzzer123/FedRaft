package org.bupt.fedraft.job.jobmanager;

import org.bupt.fedraft.config.Configuration;
import org.bupt.fedraft.state.JobManager;
import org.bupt.fedraft.state.ManagerState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JobManager所有Raft状态的抽象父类
 *
 * @author yzzer
 */
public abstract class BaseJob {
    public static final int BASE_HEARTBEAT_TIMEOUT = Configuration.getInt(Configuration.MANAGER_HEARTBEAT_TIME_INTERVAL);
    private static final Logger logger = LoggerFactory.getLogger(BaseJob.class);
    final private JobManager jobManager;
    final private ManagerState managerState;

    public BaseJob(JobManager manager, ManagerState managerState) {
        jobManager = manager;
        this.managerState = managerState;
    }

    public ManagerState getManagerState() {
        return managerState;
    }

    public JobManager getJobManager() {
        return jobManager;
    }

    /**
     * 启动倒计时任务
     */
    abstract public void setupTimer();

    /**
     * 关闭倒计时任务
     */
    abstract public void closeTimer();

    /**
     * 重置倒计时任务
     */
    public void resetTimer() {
        closeTimer();
        setupTimer();
    }
}
