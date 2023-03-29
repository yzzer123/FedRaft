package org.bupt.fedraft.server;

import com.google.protobuf.ByteString;
import io.grpc.stub.StreamObserver;
import org.bupt.fedraft.beans.NodeInfo;
import org.bupt.fedraft.rpc.trainer.message.*;
import org.bupt.fedraft.rpc.trainer.service.TrainerServiceGrpc;
import org.bupt.fedraft.state.JobManager;
import org.bupt.fedraft.state.ManagerState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/**
 * 负责与Trainer通信的类
 *
 * @author yzzer
 */
public class TrainerClient extends Client {

    private static final Logger logger = LoggerFactory.getLogger(TrainerClient.class);

    private final TrainerServiceGrpc.TrainerServiceBlockingStub blockingStub;
    private final TrainerServiceGrpc.TrainerServiceStub asyncStub;
    private final int port;

    private final JobManager jobManager;

    public TrainerClient(JobManager jobManager, ManagerState managerState, int port) {
        super(managerState, new NodeInfo("localhost", port));
        this.blockingStub = TrainerServiceGrpc.newBlockingStub(getChannel());
        this.asyncStub = TrainerServiceGrpc.newStub(getChannel());
        this.port = port;
        this.jobManager = jobManager;
    }


    public StreamObserver<InitModelRequest> initModel() {
        return asyncStub.initModel(new StreamObserver<>() {
            @Override
            public void onNext(InitModelResponse response) {
                if (!response.getStatus()) {
                    logger.error("model init failed on trainer(port: {})", port);
                    jobManager.sendLog("job failed. due to model init failed on trainer port: " + port, false);
                    getManagerState().deleteJobState(jobManager.sourceId, jobManager.uuid);
                }
            }

            @Override
            public void onError(Throwable t) {
                logger.error("model init canceled due to " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                logger.info("model init success on trainer(port: {})", port);
                jobManager.sendLog("model init success on trainer port: " + port, false);
            }
        });
    }

    /**
     * 同步训练模型
     *
     * @param modelChunks 待训练模型, 可以发送null直接触发训练
     * @return 正常训练结束后，返回训练后的模型，发生异常则返回null
     */
    public List<ByteString> trainModel(@Nonnull List<ByteString> modelChunks) {

        final List<ByteString> trainedModel = new ArrayList<>(modelChunks.size());
        final CountDownLatch isFinished = new CountDownLatch(1);

        StreamObserver<TrainRequest> requestObserver = asyncStub.trainModel(new StreamObserver<>() {
            @Override
            public void onNext(TrainResponse response) {
                trainedModel.add(response.getModelChunk());
            }

            @Override
            public void onError(Throwable t) {
                logger.error("model training failed :" + t.getMessage());
                trainedModel.clear();
                isFinished.countDown();
            }

            @Override
            public void onCompleted() {
                isFinished.countDown();
            }
        });

        if (modelChunks.size() != 0) {
            for (ByteString modelChunk : modelChunks) {
                // 发送模型给Trainer，触发训练
                requestObserver.onNext(TrainRequest.newBuilder().setModelChunk(modelChunk).build());
            }
        }

        requestObserver.onCompleted();

        try {
            isFinished.await();
        } catch (InterruptedException e) {
            logger.error("model training failed :" + e.getMessage());
            return null;
        }

        return trainedModel.size() == 0 ? null : trainedModel;
    }

    public List<ByteString> trainModel() {
        return trainModel(new ArrayList<>());
    }

    /**
     * 异步训练模型
     *
     * @param responseObserver 模型回复监听器
     * @return 返回发送监听器
     */
    public StreamObserver<TrainRequest> trainModel(@Nonnull StreamObserver<TrainResponse> responseObserver) {
        return asyncStub.trainModel(responseObserver);
    }

    /**
     * 作为Leader向trainer推送模型
     *
     * @return 返回一个异步发送器
     */
    public StreamObserver<PushModelRequest> pushModel() {

        return asyncStub.pushModel(new StreamObserver<>() {
            @Override
            public void onNext(PushModelResponse response) {
            }

            @Override
            public void onError(Throwable t) {
                logger.error("push model failed:" + t.getMessage());
            }

            @Override
            public void onCompleted() {

            }
        });
    }


    /**
     * 同步发送模型
     *
     * @param modelChunks 模型块
     * @param id          模型ID
     */
    public void pushModel(@Nonnull List<ByteString> modelChunks, Long id) {

        final CountDownLatch isFinished = new CountDownLatch(1);
        StreamObserver<PushModelRequest> requestObserver = asyncStub.pushModel(new StreamObserver<>() {
            @Override
            public void onNext(PushModelResponse response) {
            }

            @Override
            public void onError(Throwable t) {
                logger.error("push model failed:" + t.getMessage());
                isFinished.countDown();
            }

            @Override
            public void onCompleted() {
                isFinished.countDown();
            }
        });
        // 发送ID
        requestObserver.onNext(PushModelRequest.newBuilder().setServerId(id).build());

        for (ByteString modelChunk : modelChunks) {
            requestObserver.onNext(PushModelRequest.newBuilder().setModelChunk(modelChunk).build());
        }

        try {
            isFinished.await();
        } catch (InterruptedException e) {
            logger.error("push model failed:" + e.getMessage());
        }

    }


    /**
     * 触发trainer合并模型
     *
     * @param collectedIds 收集到的模型ID， 用于检查Trainer是否有模型缺漏
     * @param modelCache   模型缓存， 当发生缺漏时进行重发
     * @return 返回合并后的模型
     */
    public List<ByteString> mergeModel(@Nonnull List<Long> collectedIds,
                                       @Nonnull Map<Long, List<ByteString>> modelCache) {

        MergeRequest mergeRequest = MergeRequest.newBuilder().addAllServerIds(collectedIds).build();
        List<ByteString> mergedModel = new ArrayList<>();
        while (true) {
            Iterator<MergeResponse> responseIterator = blockingStub.mergeModel(mergeRequest);
            MergeResponse response = responseIterator.next();

            // 当Trainer的模型不全时，需要重新推送模型，完成后继续尝试合并模型
            if (response.hasServerId()) {
                pushModel(modelCache.get(response.getServerId()), response.getServerId());
                continue;
            }

            // 当回复的是模型时，可以开始收集模型块，并返回结果
            mergedModel.add(response.getModelChunk());
            while (responseIterator.hasNext()) {
                response = responseIterator.next();
                mergedModel.add(response.getModelChunk());
            }
            break;
        }

        return mergedModel;
    }


}
