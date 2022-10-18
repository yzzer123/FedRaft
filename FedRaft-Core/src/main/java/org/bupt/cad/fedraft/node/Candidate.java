package org.bupt.cad.fedraft.node;

import org.bupt.cad.fedraft.rpc.message.HeartbeatRequest;

public class Candidate extends Node {
    @Override
    public int receiveHeartbeat(HeartbeatRequest request) {
        return 0;
    }

    @Override
    public void close() {
    }
}
