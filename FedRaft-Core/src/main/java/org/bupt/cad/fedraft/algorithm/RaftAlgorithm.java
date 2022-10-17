package org.bupt.cad.fedraft.algorithm;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bupt.cad.fedraft.node.Node;
import org.bupt.cad.fedraft.rpc.message.HeartbeatRequest;
import org.bupt.cad.fedraft.server.FedRaftServer;


public class RaftAlgorithm implements Algorithm {

    private static final Logger logger = LogManager.getLogger(FedRaftServer.class.getName());

    @Override
    public int heartbeat(HeartbeatRequest request) {

//        int leaderTerm = request.getTerm();
//        if(Node.getState() == NodeState.SAFE_MODE){ //-1, 0
//            Node.resetHeartbeatTimer();
//            if(Node.term <= leaderTerm){
//                Node.term = leaderTerm;
//                if(SafeMode.checkLegal())
//                    Node.setState(NodeState.FOLLOWER);
//            }else {
//                return -1;
//            }
//        }else {
//            //follower
//            Node.resetHeartbeatTimer();
//        }
//
//        logger.info("get heartbeat request from " + NodeInfo.idToIp(request.getLeaderId()));
//        List<Integer> networkDelaysList = request.getNetworkDelaysList();
//        List<Long> nodeIdsList = request.getNodeIdsList();
//        logger.info("收到的数据长度:" + networkDelaysList.size());
//        if (networkDelaysList.size() != nodeIdsList.size()) {
//            return -1;
//        }
//        for (int i = 0; i < nodeIdsList.size(); i++) {
//            Node.topologies.putIfAbsent(nodeIdsList.get(i), networkDelaysList.get(i));
//        }
        return Node.getRuntimeNode().getNodeMode().receiveHeartbeat(request);
    }

}
