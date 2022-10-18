package org.bupt.cad.fedraft.node;

import org.bupt.cad.fedraft.rpc.message.HeartbeatRequest;

public class Follower extends Node {


    public Follower() {

    }

    @Override
    public int receiveHeartbeat(HeartbeatRequest request) {

        // 获取运行时状态
        Runtime runtime = Runtime.getRuntime();


        // follower收到的心跳信息可能来自 tmp_leader 和 leader,
        if (request.getTerm() > runtime.getTerm()) {
            // 跟随该leader 将任期提升
            runtime.setTerm(request.getTerm())
                    .setLeader(request.getLeaderId());

        } else if (request.getTerm() < runtime.getTerm()) {
            // 任期比自己小就为错误
            return -1;
        }

        // 更新自己的时延拓扑
        updateTopology(request.getNodeIdsList(), request.getNetworkDelaysList());

        return Runtime.getRuntime().getDelay().get();
    }


    @Override
    public void close() {
    }
}
