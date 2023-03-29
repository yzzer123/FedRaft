package org.bupt.fedraft.state;

import org.bupt.fedraft.job.manager.BaseJob;

/**
 * @author yzzer
 */
public class ManagerRaftState {

    // 任期
    public int term = Integer.MIN_VALUE;

    // 日志索引 每发一次心跳更新一次
    public long entryIndex = Long.MIN_VALUE;
    public long voteFor = -1;

    public BaseJob job;

    @Override
    public String toString() {
        return "ManagerRaftState{" +
                "term=" + term +
                ", entryIndex=" + entryIndex +
                ", voteFor=" + voteFor +
                ", job=" + job.getClass().getName() +
                '}';
    }
}
