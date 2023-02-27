package org.bupt.cad.fedraft.algorithm;

import org.bupt.cad.fedraft.node.fedraft.Runtime;
import org.bupt.cad.fedraft.rpc.message.HeartbeatRequest;
import org.bupt.cad.fedraft.rpc.message.VoteRequest;


public class FedRaftAlgorithm implements Algorithm {


    private final Runtime runtime;

    public FedRaftAlgorithm(Runtime runtime){
        this.runtime = runtime;
    }

    @Override
    public Runtime getRuntime() {
        return runtime;
    }

    @Override
    public int heartbeat(HeartbeatRequest request) {


        return getRuntime().getNodeMode().receiveHeartbeat(request);
    }

    @Override
    public boolean voteFor(VoteRequest request) {
        return getRuntime().getNodeMode().voteFor(request);
    }
}
