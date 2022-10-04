package org.bupt.cad.fedraft.server;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.bupt.cad.fedraft.rpc.service.FedRaftServiceGrpc;

import java.util.logging.Logger;

public class FedRaftClient {
    private static final Logger logger = Logger.getLogger(FedRaftClient.class.getName());

    private final ManagedChannel channel;
    private final FedRaftServiceGrpc.FedRaftServiceBlockingStub blockingStub;
    private final FedRaftServiceGrpc.FedRaftServiceStub asyncStub;
    private final FedRaftServiceGrpc.FedRaftServiceFutureStub futureStub;

    public FedRaftClient(String host, int port) {
        this.channel = ManagedChannelBuilder.forAddress(host, port).build();
        this.blockingStub = FedRaftServiceGrpc.newBlockingStub(channel);
        this.asyncStub = FedRaftServiceGrpc.newStub(channel);
        this.futureStub = FedRaftServiceGrpc.newFutureStub(channel);
    }


}
