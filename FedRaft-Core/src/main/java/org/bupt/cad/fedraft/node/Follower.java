package org.bupt.cad.fedraft.node;

import org.bupt.cad.fedraft.rpc.message.HeartbeatRequest;

public class Follower implements NodeMode {
    @Override
    public int receiveHeartbeat(HeartbeatRequest request) {
        return 0;
    }
}
