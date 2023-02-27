package org.bupt.fedraft.server;

import io.grpc.stub.StreamObserver;
import org.bupt.fedraft.beans.NodeInfo;
import org.bupt.fedraft.rpc.trainer.message.InitModelRequest;
import org.bupt.fedraft.rpc.trainer.message.InitModelResponse;
import org.bupt.fedraft.rpc.trainer.service.TrainerServiceGrpc;
import org.bupt.fedraft.state.ManagerState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TrainerClient extends Client {

    private static final Logger logger = LoggerFactory.getLogger(TrainerClient.class);

    private final TrainerServiceGrpc.TrainerServiceBlockingStub blockingStub;
    private final TrainerServiceGrpc.TrainerServiceStub asyncStub;

    private final int port;

    public TrainerClient(ManagerState managerState, int port) {
        super(managerState, new NodeInfo("localhost", port));
        this.blockingStub = TrainerServiceGrpc.newBlockingStub(getChannel());
        this.asyncStub = TrainerServiceGrpc.newStub(getChannel());
        this.port = port;
    }


    public StreamObserver<InitModelRequest> initModel() {
        return asyncStub.initModel(new StreamObserver<>() {
            @Override
            public void onNext(InitModelResponse response) {
                if (!response.getStatus()) {
                    logger.error("model init failed on trainer(port: {})", port);
                }
            }

            @Override
            public void onError(Throwable t) {
                logger.error(t.getMessage());
            }

            @Override
            public void onCompleted() {
                logger.info("model init success on trainer(port: {})", port);
            }
        });
    }

    public void trainerModel() {

    }

    public void pushModel() {

    }

    public void mergeModel() {

    }


}
