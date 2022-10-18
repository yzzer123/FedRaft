package org.bupt.cad.fedraft.node;

import org.bupt.cad.fedraft.rpc.message.HeartbeatRequest;

public class Follower extends Node {


    @Override
    public int receiveHeartbeat(HeartbeatRequest request) {
        return 0;
    }

    public Follower() {

    }

    @Override
    public void close() {
    }
}
