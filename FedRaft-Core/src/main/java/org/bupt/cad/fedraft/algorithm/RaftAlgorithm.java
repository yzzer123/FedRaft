package org.bupt.cad.fedraft.algorithm;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bupt.cad.fedraft.beans.NodeInfo;
import org.bupt.cad.fedraft.rpc.message.HeartbeatRequest;
import org.bupt.cad.fedraft.server.FedRaftServer;
import org.bupt.cad.fedraft.server.Node;

import java.util.List;

public class RaftAlgorithm implements Algorithm {

    private static final Logger logger = LogManager.getLogger(FedRaftServer.class.getName());

    @Override
    public int heartbeat(HeartbeatRequest request) {


        int leaderTerm = request.getTerm();
        leaderTerm = 0;//手动测试

        if (Node.term < leaderTerm) { //初次建立心跳连接时,修改follower任期,并初始化计时器
            Node.term = leaderTerm;
            Node.resetHeartbeatTimer();
        } else { //重置计时器
            return -1;
        }
        logger.info("get heartbeat request from " + NodeInfo.idToIp(request.getLeaderId()));
        List<Float> networkDelaysList = request.getNetworkDelaysList();
        List<Long> nodeIdsList = request.getNodeIdsList();
        logger.info("收到的数据长度:" + networkDelaysList.size());
        if (networkDelaysList.size() != nodeIdsList.size()) {
            return -1;
        }
        for (int i = 0; i < nodeIdsList.size(); i++) {
            Node.topologies.putIfAbsent(nodeIdsList.get(i), networkDelaysList.get(i));//理应已有当前nodeInfo
        }

        return Node.delay;
    }


}
