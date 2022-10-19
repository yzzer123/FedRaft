package org.bupt.cad.fedraft.algorithm;

import org.bupt.cad.fedraft.node.Runtime;
import org.bupt.cad.fedraft.rpc.message.HeartbeatRequest;


public class RaftAlgorithm implements Algorithm {

    @Override
    public int heartbeat(HeartbeatRequest request) {


        return Runtime.getRuntime().getNodeMode().receiveHeartbeat(request);
    }

}
