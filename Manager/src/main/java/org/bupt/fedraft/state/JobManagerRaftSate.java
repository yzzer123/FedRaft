package org.bupt.fedraft.state;

import org.bupt.fedraft.job.jobmanager.BaseJob;

/**
 * @author yzzer
 */
public class JobManagerRaftSate {

    public int term = Integer.MIN_VALUE;
    /**
     * 本地模型索引，用于记录本地训练好的模型索引
     */
    public long localModelIndex = Long.MIN_VALUE;
    /**
     * 全局模型索引，用于记录收到的最新的全局模型的索引
     */
    public long globalModelIndex = Long.MIN_VALUE;
    public long voteFor = -1;
    public boolean canSendModel = false;
    private BaseJob job;

    public BaseJob getJob() {
        return job;
    }

    public JobManagerRaftSate setJob(BaseJob job) {
        this.job = job;
        return this;
    }
}
