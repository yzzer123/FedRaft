package org.bupt.cad.fedraft.server;


import io.grpc.stub.StreamObserver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bupt.cad.fedraft.beans.NodeInfo;
import org.bupt.cad.fedraft.rpc.message.HeartbeatRequest;
import org.bupt.cad.fedraft.rpc.message.HeartbeatResponse;
import org.bupt.cad.fedraft.rpc.message.LogRequest;
import org.bupt.cad.fedraft.rpc.message.LogResponse;
import org.bupt.cad.fedraft.rpc.service.FedRaftServiceGrpc;

import java.util.List;



/**
 * RPC通信服务实现类
 */
public class FedRaftService extends FedRaftServiceGrpc.FedRaftServiceImplBase {


    private static final Logger logger = LogManager.getLogger(FedRaftServer.class.getName());

    //todo 建立计时器感知超时
    @Override
    public void heartbeat(HeartbeatRequest request, StreamObserver<HeartbeatResponse> responseObserver) {
        if (Node.getState() != Node.NodeState.FOLLOWER) {
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

}
