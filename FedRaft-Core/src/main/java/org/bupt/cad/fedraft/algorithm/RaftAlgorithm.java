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
//                if(SafeModeNode.checkLegal())
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
        switch (Node.getRuntimeNode().getState()) {
            case SAFE_MODE:
                return safeModeHeartbeat(request);
            case FOLLOWER:
                return followerHeartbeat(request);
            case TMP_LEADER:
                return tmpLeaderHeartbeat(request);
            case LEADER:
                return leaderHeartbeat(request);
            case CANDIDATE:
                return candidateHeartbeat(request);
        }
        return -1;
    }

    private int candidateHeartbeat(HeartbeatRequest request) {
        return 0;
    }

    private int leaderHeartbeat(HeartbeatRequest request) {
        return 0;
    }

    private int tmpLeaderHeartbeat(HeartbeatRequest request) {
        return 0;

    }

    private int followerHeartbeat(HeartbeatRequest request) {
        return 0;

    }

    private int safeModeHeartbeat(HeartbeatRequest request) {


        Node.getRuntimeNode().getTopologies().clear();

        Node.getRuntimeNode().getTopologies().

        return 0;

    }
}
