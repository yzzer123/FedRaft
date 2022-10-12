package org.bupt.cad.fedraft.server;


import com.google.protobuf.ByteString;
import io.grpc.stub.StreamObserver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bupt.cad.fedraft.beans.NodeInfo;
import org.bupt.cad.fedraft.config.Configuration;
import org.bupt.cad.fedraft.exception.LogAppendException;
import org.bupt.cad.fedraft.rpc.message.HeartbeatRequest;
import org.bupt.cad.fedraft.rpc.message.HeartbeatResponse;
import org.bupt.cad.fedraft.rpc.message.LogRequest;
import org.bupt.cad.fedraft.rpc.message.LogResponse;
import org.bupt.cad.fedraft.rpc.service.FedRaftServiceGrpc;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;



/**
 * RPC通信服务实现类
 */
public class FedRaftService extends FedRaftServiceGrpc.FedRaftServiceImplBase {


    private static final Logger logger = LogManager.getLogger(FedRaftServer.class.getName());

    //todo 建立计时器感知超时
    @Override
    public void heartbeat(HeartbeatRequest request, StreamObserver<HeartbeatResponse> responseObserver) {
        if(Node.STATE != 1){
            responseObserver.onError(new Exception("计时器已超时"));
            logger.info("计时器超时,节点状态已被切换");
            return;
        }
        int leaderTerm = request.getTerm();
        leaderTerm = 0;//手动测试
        if(Node.term + 1 < leaderTerm){
            responseObserver.onError(new Exception("节点任期异常"));//to do
            return;
        }
        if(Node.term + 1 == leaderTerm){ //初次建立心跳连接时,修改follower任期,并初始化计时器
            Node.term = leaderTerm;
            Node.heartbeatTimerInit();
        }else { //重置计时器
            Node.heartbeatTimerUpdate();
        }
        logger.info("get heartbeat request from " + NodeInfo.idToIp(request.getLeaderId()));
        List<Float> networkDelaysList = request.getNetworkDelaysList();
        List<Long> nodeIdsList = request.getNodeIdsList();
        logger.info("收到的数据长度:"+networkDelaysList.size());
        if(networkDelaysList.size() != nodeIdsList.size()){
            responseObserver.onError(new Exception("数据流异常:时延数和节点数不同"));
            return;
        }
        for(int i = 0; i < nodeIdsList.size(); i++){
            Node.topologies.putIfAbsent(nodeIdsList.get(i), networkDelaysList.get(i));//理应已有当前nodeInfo
        }
        HeartbeatResponse response = HeartbeatResponse.newBuilder().setNetworkDelay(Node.delay).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
        logger.info("follower节点完成一次心跳传输");
    }

    @Override
    public void appendLog(LogRequest request, StreamObserver<LogResponse> responseObserver) {

    }


    /**
     * 接受client传递来的流式数据块， 该数据块一般是模型序列化后切分出来的字节流, 不能用于维护心跳信息
     *
     * @param responseObserver 服务端回调，用于向客户端恢回复数据和结束通信
     * @return StreamObserver<LogRequest> 客户端回调，用于监听客户端传递的每一条数据
     */
    @Override
    public StreamObserver<LogRequest> appendStreamLog(StreamObserver<LogResponse> responseObserver) {

        /*
            数据来源有两种可能
                1. trainer -> manager trainer主动发送模型，处于模型的汇总阶段
                2. manager -> manager 分为leader向多个client发送和client向leader发送
        */
        return new StreamObserver<>() {

            private long totalSize = 0L;  // 统计总数据量
            private StreamObserver<LogRequest> sendObserver;  // 用于转发块
            final CountDownLatch finishLatch = new CountDownLatch(1);

            private void setSendObserver(LogRequest.LogType type){
                // TODO client改成从channel池中获取
                switch (type){
                    case TRAINER_TO_MANAGER:
                        // 发起client到leader的请求
                        sendObserver = new FedRaftClient(Configuration.getString(Configuration.MANAGER_SERVER_HOST),
                                Configuration.getInt(Configuration.MANAGER_SERVER_PORT))
                                .getAsyncStub().withDeadlineAfter(5, TimeUnit.SECONDS)
                                .appendStreamLog(new ResponseObserver());
                    case CLIENT_TO_LEADER:
                    case LEADER_TO_CLIENT:
                    case UNRECOGNIZED:
                        sendObserver = new FedRaftClient(Configuration.getString(Configuration.MANAGER_SERVER_HOST),
                                Configuration.getInt(Configuration.TRAINER_SERVER_PORT))
                                .getAsyncStub().withDeadlineAfter(5, TimeUnit.SECONDS)
                                .appendStreamLog(new ResponseObserver());
                }
            }

            private LogRequest.LogType getNextLogType(LogRequest.LogType logType){
                switch (logType){
                    case TRAINER_TO_MANAGER:
                        return LogRequest.LogType.CLIENT_TO_LEADER;
                    case CLIENT_TO_LEADER:
                    case LEADER_TO_CLIENT:
                    case UNRECOGNIZED:
                        return LogRequest.LogType.MANAGER_TO_TRAINER;
                }
                return null;
            }

            @Override
            public void onNext(LogRequest logRequest) {
                // TODO 实现leader向client的分发
                // 每接受到一个数据块 进行转发
                if (sendObserver == null){
                    setSendObserver(logRequest.getLogType());
                }

                ByteString chunkData = logRequest.getModelChunk();
                totalSize += chunkData.size();
                // 深拷贝数据 并修改数据来源
                LogRequest newLogRequest = logRequest.toBuilder()
                        .setLogType(getNextLogType(logRequest.getLogType()))
                        .build();
                // 转发数据
                sendObserver.onNext(newLogRequest);

            }

            @Override
            public void onError(Throwable t) {
                // TODO 考虑边界情况
                logger.warn("unexpected error: " + t.getMessage(), t);
            }

            @Override
            public void onCompleted() {
                // TODO 考虑宕机情况
                sendObserver.onCompleted();
                // 源端发送结束，等待接受端完成接受
                try {
                    // 接受端还未接受完成，最多等待20s
                    if (!finishLatch.await(20, TimeUnit.SECONDS)){
                        logger.error("request can't finish in 20seconds");
                        responseObserver.onError(new LogAppendException("request can't finish in 20seconds"));
                    }

                } catch (InterruptedException e) {
                    logger.error("request can't finish" + e.getMessage(), e);
                }finally {
                    LogResponse response = LogResponse.newBuilder().setLogSize(totalSize).build();
                    responseObserver.onNext(response);
                    responseObserver.onCompleted();
                }
            }

            class ResponseObserver implements StreamObserver<LogResponse>{

                @Override
                public void onNext(LogResponse response) {
                    logger.info("received response from server: " + response);
                }

                @Override
                public void onError(Throwable t) {
                    logger.error("upload failed" + t.getMessage(), t);
                    finishLatch.countDown();
                }

                @Override
                public void onCompleted() {
                    logger.info("image uploaded");
                    finishLatch.countDown();
                }
            }

        };
    }
}
