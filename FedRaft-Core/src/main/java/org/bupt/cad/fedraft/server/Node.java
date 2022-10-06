package org.bupt.cad.fedraft.server;

import com.google.protobuf.ByteString;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Node {

    //该节点感知到的其他节点
    List<String> nodeList = new ArrayList<>();//xx.xx.xx.xx:????
    ExecutorService executor = Executors.newFixedThreadPool(10);//nodeList.size()
    int heartbeatMaxTime = 1000;
    long lastHeartbeat = 0L;
    boolean heartbeatFlag = true;//作为leader是否持续发送心跳

    //leader节点向其他节点发送心跳信息
    public void maintainHeartbeat(){
        for(String ip_port:nodeList){
            executor.submit(()->{
                String[] split = ip_port.split(":");
                FedRaftClient fedRaftClient = new FedRaftClient(split[0], Integer.parseInt(split[1]));
                double delay = 2.2;//局部函数获取
                ByteString bytes = ByteString.copyFrom(String.valueOf(delay).getBytes());
                while(heartbeatFlag){
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    fedRaftClient.sendHeartBeat(1,2, bytes);
                }
                //最后一次传送心跳信息,故意设置让follower节点超时
                //Thread.sleep(1000);
                fedRaftClient.sendHeartBeat(1,2, bytes);
            });
        }
    }

    //follower节点接收心跳信息,并存下时延
    public void getHeartbeat(double delay){
        if(lastHeartbeat == 0L || System.currentTimeMillis() - lastHeartbeat <= 1000){
            lastHeartbeat = System.currentTimeMillis();
            //存下delay
        }else{
            //超时,发生超时
            //切换当前节点状态,不再是follower节点
        }
    }

}
