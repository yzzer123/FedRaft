package org.bupt.cad.fedraft.node;

import org.bupt.cad.fedraft.rpc.message.HeartbeatRequest;

public interface NodeMode {
    int receiveHeartbeat(HeartbeatRequest request);

    /**
     * 退出原来的模式时要做的善后工作
     */
    void close();
}
