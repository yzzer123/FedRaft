package org.bupt.cad.fedraft.node;

import org.bupt.cad.fedraft.rpc.message.HeartbeatRequest;

import java.util.concurrent.ScheduledFuture;


/**
 * TODO 请求投票
 * TODO 选举超时，检查自己是否还有资格继续保持candidate， 否则就转换为follower，重置选举状态
 */
public class Candidate extends Node {

    private ElectionExecutor electionState;

    private ScheduledFuture<?> timeoutTask;

    public Candidate(ElectionExecutor electionState) {
        this.electionState = electionState;
    }

    public void electionTimeout() {

    }


    @Override
    public int receiveHeartbeat(HeartbeatRequest request) {
        return 0;
    }


    @Override
    public void close() {

    }
}
