package org.bupt.fedraft.server;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.bupt.fedraft.beans.NodeInfo;
import org.bupt.fedraft.job.manager.BaseJob;
import org.bupt.fedraft.state.ManagerState;

import java.util.concurrent.TimeUnit;

public class Client {


    private final ManagedChannel channel;
    private final NodeInfo clientInfo;

    private final ManagerState managerState;


    public Client(ManagerState managerState, NodeInfo clientInfo) {
        this.channel = ManagedChannelBuilder.forAddress(clientInfo.getIp(), clientInfo.getPort())
                .usePlaintext().idleTimeout(6L * BaseJob.BASE_HEARTBEAT_TIMEOUT, TimeUnit.MILLISECONDS)
                .enableRetry()
                .maxInboundMessageSize(536870912).build();
        this.clientInfo = clientInfo;
        this.managerState = managerState;
    }

    public ManagerState getManagerState() {
        return managerState;
    }

    protected ManagedChannel getChannel() {
        return channel;
    }

    public NodeInfo getClientInfo() {
        return clientInfo;
    }

    public void close() {
        channel.shutdownNow();
    }

}
