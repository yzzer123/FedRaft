package org.bupt.fedraft.server;

import com.google.protobuf.ByteString;
import io.grpc.Context;
import io.grpc.stub.StreamObserver;
import org.bupt.fedraft.beans.NodeInfo;
import org.bupt.fedraft.exception.LocalTrainException;
import org.bupt.fedraft.rpc.trainer.message.*;
import org.bupt.fedraft.rpc.trainer.service.TrainerServiceGrpc;
import org.bupt.fedraft.state.JobManager;
import org.bupt.fedraft.state.ManagerState;
import org.bupt.fedraft.utils.VisitType;
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
     * @throws LocalTrainException 训练过程发生异常或被打断
     */
    public void trainModel(List<ByteString> modelChunks, @Nonnull final List<ByteString> trainedModel) throws LocalTrainException {

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

        if (modelChunks != null) {
            for (ByteString modelChunk : modelChunks) {
                // 发送模型给Trainer，触发训练
                requestObserver.onNext(TrainRequest.newBuilder().setModelChunk(modelChunk).build());
            }
        }

        requestObserver.onCompleted();

        try {
            isFinished.await();
        } catch (InterruptedException e) {
            throw new LocalTrainException("model training interrupted :" + e.getMessage());
        }

        if (trainedModel.size() == 0) {
            throw new LocalTrainException("model from trainer with size:0");
        }
    }

    /**
     * 初始化完成后的本地训练/使用之前的参数进行本地训练
     */
    public void trainModel() {
        // 关闭计时器防止训练过程中触发重新选举
        jobManager.getRaftState().visit(raftSate -> raftSate.getJob().closeTimer(), VisitType.READ);
        jobManager.getLocalModel().visit(modelChunkCache -> {
            modelChunkCache.clear();
            try {
                trainModel(null, modelChunkCache);
            } catch (LocalTrainException e) {
                logger.error(e.getMessage());
            }
        }, VisitType.WRITE);

        triggerModelCollect();

    }


    /**
     * TODO 完成本地训练后触发模型回收或leader选举
     */
    private void triggerModelCollect() {

    }

    /**
     * 异步训练模型
     */
    public void trainModel(@Nonnull Context context) {
        // 关闭计时器防止训练过程中触发重新选举
        jobManager.getRaftState().visit(raftSate -> raftSate.getJob().closeTimer(), VisitType.READ);

        Context newContext = context.fork();

        newContext.run(() -> {
            StreamObserver<TrainRequest> modelSender = asyncStub.trainModel(new StreamObserver<>() {
                private final List<ByteString> trainedModel = new ArrayList<>();

                @Override
                public void onNext(TrainResponse response) {
                    trainedModel.add(response.getModelChunk());
                }

                @Override
                public void onError(Throwable t) {
                    logger.error(t.getMessage());
                }

                @Override
                public void onCompleted() {
                    // 将本地模型写入状态缓存
                    jobManager.getLocalModel().visit(modelChunks -> {
                        modelChunks.clear();
                        modelChunks.addAll(trainedModel);
                    }, VisitType.WRITE);
                    triggerModelCollect();
                }
            });

            // 清空全局模型缓存，初始化发送器，等待接受模型
            jobManager.clearGlobalModelChunk(modelSender);
        });
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
