package org.bupt.fedraft.job.jobmanager;

import com.google.protobuf.ByteString;
import org.bupt.fedraft.config.Configuration;
import org.bupt.fedraft.state.JobManager;
import org.bupt.fedraft.state.ManagerState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

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
     * 向Leader发送模型
     * @param model
     */
    public void collectModel(List<ByteString> model){



        // TODO 未实现处于无法发送状态时的缓存以及触发选举
    }



    /**
     * 重置倒计时任务
     */
    public void resetTimer() {
        closeTimer();
        setupTimer();
    }
}
