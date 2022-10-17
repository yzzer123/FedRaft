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


        return Node.getRuntimeNode().getNodeMode().receiveHeartbeat(request);
    }

}
