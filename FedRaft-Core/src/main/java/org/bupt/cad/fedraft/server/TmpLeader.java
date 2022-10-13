package org.bupt.cad.fedraft.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TmpLeader {

    private static final Logger logger = LogManager.getLogger(FedRaftServer.class.getName());

    private static AtomicInteger sum = new AtomicInteger(0);

    private static final ConcurrentHashMap<Long, Integer> countTimes = new ConcurrentHashMap<>();

    //开始工作,计时器定时发送心跳连接
    public static void init(){
        for(Long nodeId : Node.topologies.keySet()){
            Node.buildChannel(nodeId);
        }
        maintainHeartbeat();
        checkSum();
    }

    private static void maintainHeartbeat() {

        // TODO 改为单一计时器
        for (Long nodeId : Node.clientChannels.keySet()) {
            ScheduledFuture<?> scheduledFuture = Node.executor.scheduleAtFixedRate(() -> {
                FedRaftClient client = Node.clientChannels.get(nodeId);
                client.sendHeartBeat(Node.term, Node.selfNodeInfo.getNodeId(), nodeId);

            }, 0, 2000, TimeUnit.MILLISECONDS);

        }
    }

    public static boolean count(Long clientId){
        countTimes.putIfAbsent(clientId, countTimes.getOrDefault(clientId, 0) + 1);
        if(countTimes.get(clientId) >= 2){
            sum.addAndGet(1);
            return false;
        }else{
            return true;
        }
    }

    //每隔一段时间检查sum值是否大于一半的节点数
    private static void checkSum() {
        if(sum.get() > 5){
            Node.setState(NodeState.FOLLOWER);
            logger.info("开启选举 startElection");
        }
    }
}
