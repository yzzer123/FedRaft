package org.bupt.cad.fedraft.node;

import org.bupt.cad.fedraft.rpc.message.HeartbeatRequest;


/**
 * follower的功能：
 * 1. 通过心跳和leader同步时延 和 SAFE_MODE类似
 * 2. 当接收到任期大的leader时，更改追随目标， TODO 如果模型索引更新，就通知trainer拉取新的模型
 * 3. TODO 设置超时器， 当心跳超时时触发选举， 如果能够成为Candidate 就转换状态请求其他节点投票
 * 4. TODO 当接受到心跳时，重置超时器
 * 5. TODO 当收到投票请求时，检查请求者是否合法(任期，时延大小2th，模型索引)，提升自己的任期， 记录投票状态，一个任期内只能投给其中一个leader
 * 6. TODO 维护一个选举状态，当收到新leader的心跳之后就可以删除选举状态
 */
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
