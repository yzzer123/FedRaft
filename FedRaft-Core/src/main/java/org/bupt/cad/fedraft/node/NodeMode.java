package org.bupt.cad.fedraft.node;

import org.bupt.cad.fedraft.rpc.message.HeartbeatRequest;

public interface NodeMode {
    int receiveHeartbeat(HeartbeatRequest request);
}
