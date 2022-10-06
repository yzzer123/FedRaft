package org.bupt.cad.fedraft.server;


import com.google.protobuf.ByteString;
import io.grpc.stub.StreamObserver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bupt.cad.fedraft.rpc.message.LogRequest;
import org.bupt.cad.fedraft.rpc.message.LogResponse;
import org.bupt.cad.fedraft.rpc.service.FedRaftServiceGrpc;

import java.util.Arrays;


/**
 * RPC通信服务实现类
 */
public class FedRaftService extends FedRaftServiceGrpc.FedRaftServiceImplBase {


    private static final Logger logger = LogManager.getLogger(FedRaftServer.class.getName());


    @Override
    public void appendLog(LogRequest request, StreamObserver<LogResponse> responseObserver) {

        //follower节点每隔一定时间接收到心跳信息
        int term = request.getTerm();
        ByteString bytes = request.getNetworkDelays();
        double delay = Double.parseDouble(Arrays.toString(bytes.toByteArray()));
        int leaderId = request.getLeaderId();
        logger.info(String.format("get heartbeat from leader:%d, term:%d, delay:%f",leaderId,term,delay));

        //LogResponse build = LogResponse.newBuilder().build();
        //responseObserver.onNext(build); 接收到心跳信息,存下时延信息,
        responseObserver.onCompleted();
    }


    /**
     * 接受client传递来的流式数据块， 该数据块一般是模型序列化后切分出来的字节流, 不能用于维护心跳信息
     *
     * @param responseObserver 服务端回调，用于向客户端恢回复数据和结束通信
     * @return StreamObserver<LogRequest> 客户端回调，用于监听客户端传递的每一条数据
     */
    @Override
    public StreamObserver<LogRequest> appendStreamLog(StreamObserver<LogResponse> responseObserver) {


        return new StreamObserver<LogRequest>() {
            @Override
            public void onNext(LogRequest logRequest) {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {

            }
        };
    }
}
