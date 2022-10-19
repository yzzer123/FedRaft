package org.bupt.cad.fedraft.algorithm;

import org.bupt.cad.fedraft.rpc.message.HeartbeatRequest;

public interface Algorithm {

    int heartbeat(HeartbeatRequest request);
}
