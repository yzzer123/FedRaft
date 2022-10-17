package org.bupt.cad.fedraft.node;

import org.bupt.cad.fedraft.rpc.message.HeartbeatRequest;

public class Candidate implements NodeMode {
    @Override
    public int receiveHeartbeat(HeartbeatRequest request) {
        return 0;
    }
}
