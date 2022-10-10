package org.bupt.cad.fedraft.server;

import org.bupt.cad.fedraft.beans.NodeInfo;
import org.bupt.cad.fedraft.config.Configuration;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Node {

    //自身节点的信息
    private static final NodeInfo selfNodeInfo =
            new NodeInfo(Configuration.getString(Configuration.MANAGER_SERVER_HOST), Configuration.getInt(Configuration.MANAGER_SERVER_PORT));
    //该节点保存的时延信息
    public static final ConcurrentHashMap<NodeInfo, Float> topologies = new ConcurrentHashMap<>();
    //保存的与其他所有节点的rpc连接
    public static final ConcurrentHashMap<NodeInfo, FedRaftClient> clientChannels = new ConcurrentHashMap<>();
    public static final ExecutorService executor =
            Executors.newFixedThreadPool(Configuration.getInt(Configuration.NODE_THREADPOOL_NUMBERS));
    private static int term = -1;//当前节点的任期
    private static float delay = 10000.0f;//当前节点的平均时延 todo:是否要为静态
//    int heartbeatMaxTime = 1000;
//    long lastHeartbeat = 0L;
//    boolean heartbeatFlag = true;//作为leader是否持续发送心跳

    //leader节点向其他节点发送心跳信息
    public void maintainHeartbeat() {
        for(NodeInfo followerNode : clientChannels.keySet()){
            executor.submit(()->{
                FedRaftClient client = clientChannels.get(followerNode);
                //每隔300ms发送一次心跳,得改成计时器?
                while(true) {
                    client.sendHeartBeat(term, selfNodeInfo.getNodeId(), followerNode);
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

        }
    }

    //follower节点接收心跳信息,并存下时延
//    public void getHeartbeat(double delay){
//        if(lastHeartbeat == 0L || System.currentTimeMillis() - lastHeartbeat <= 1000){
//            lastHeartbeat = System.currentTimeMillis();
//            //存下delay
//        }else{
//            //超时,发生超时
//            //切换当前节点状态,不再是follower节点
//        }
//    }


    public static int getTerm() {
        return term;
    }

    public static void setTerm(int term) {
        Node.term = term;
    }

    public static float getDelay() {
        return delay;
    }

    public static void setDelay(float delay) {
        Node.delay = delay;
    }

    //对于节点建立rpc连接
    public void buildRpc(NodeInfo nodeInfo){
        if (clientChannels.contains(nodeInfo))
            return;
        clientChannels.put(nodeInfo, new FedRaftClient(nodeInfo.getIp(),nodeInfo.getPort()));
    }
}
