package org.bupt.cad.fedraft.algorithm;

import org.bupt.cad.fedraft.node.fedraft.Runtime;
import org.bupt.cad.fedraft.rpc.message.HeartbeatRequest;
import org.bupt.cad.fedraft.rpc.message.VoteRequest;

public interface Algorithm {

    int heartbeat(HeartbeatRequest request);

    boolean voteFor(VoteRequest request);

    Runtime getRuntime();
}
