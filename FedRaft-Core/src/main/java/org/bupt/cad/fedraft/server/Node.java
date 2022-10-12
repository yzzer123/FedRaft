package org.bupt.cad.fedraft.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bupt.cad.fedraft.beans.NodeInfo;
import org.bupt.cad.fedraft.config.Configuration;
import org.bupt.cad.fedraft.exception.StateChangeException;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.lang.Thread.sleep;

public class Node {
    private static final Logger logger = LogManager.getLogger(FedRaftServer.class.getName());

    //自身节点的信息
    private static final NodeInfo selfNodeInfo =
            new NodeInfo(Configuration.getString(Configuration.MANAGER_SERVER_HOST), Configuration.getInt(Configuration.MANAGER_SERVER_PORT), Configuration.getInt(Configuration.TRAINER_SERVER_PORT));
    //该节点保存的时延信息
    public static final ConcurrentHashMap<NodeInfo, Float> topologies = new ConcurrentHashMap<>();
    //保存的与其他所有节点的rpc连接
    public static final ConcurrentHashMap<NodeInfo, FedRaftClient> clientChannels = new ConcurrentHashMap<>();
    //保存线程池submit返回值(方便中断和启动线程)
    public static final ConcurrentHashMap<NodeInfo, Future<?>> clientFutures = new ConcurrentHashMap<>();

    public static final ExecutorService executor =
            Executors.newFixedThreadPool(Configuration.getInt(Configuration.NODE_THREADPOOL_NUMBERS));
    public static int term = -1;//当前节点的任期
    public static float delay = 10000.0f;//当前节点的平均时延 todo:是否要为静态
    //    int heartbeatMaxTime = 1000;
//    long lastHeartbeat = 0L;
//    boolean heartbeatFlag = true;//作为leader是否持续发送心跳
    private static final Long heartbeatMaxTime = Configuration.getLong(Configuration.NODE_HEARTBEAT_MAX_TIME);

    private static Timer timer;

    // 刚开始为安全模式
    private static NodeState state = NodeState.SAFE_MODE;//candidate follower leader tmp_leader  safemode

    // 收到一次全局拓扑后，就会脱离安全模式
    enum NodeState {
        SAFE_MODE, TMP_LEADER, LEADER, CANDIDATE, FOLLOWER
    }


    //便于维护每个线程的中断和开启
    static class Heartbeat extends Thread {

        private final NodeInfo followerNode;

        public Heartbeat(NodeInfo followerNode) {
            this.followerNode = followerNode;
        }

        @Override
        public void run() {
            FedRaftClient client = clientChannels.get(followerNode);
            //每隔300ms发送一次心跳,得改成计时器?(在当前子线程中开辟Timer线程,不如直接实现Timer的逻辑)
            while(!Thread.currentThread().isInterrupted()) {
                client.sendHeartBeat(term, selfNodeInfo.getNodeId(), followerNode);
                try {
                    Thread.sleep(new Random().nextInt(3)*5025);//测试, 10000ms就会超时
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                    logger.info(followerNode.getIp()+"节点超时, 停止发送心跳信息");
                    Thread.currentThread().interrupt();
                }
            }
            logger.info("当前心跳信息终止了");
        }
    }

    //leader节点向其他节点发送心跳信息
    public void maintainHeartbeat() {
        for(NodeInfo followerNode : clientChannels.keySet()) {
            Future<?> future = executor.submit(new Heartbeat(followerNode));
            clientFutures.putIfAbsent(followerNode, future);
        }
    }

    //初始化计时器
    public static void heartbeatTimerInit(){
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //超时, 当前节点切换为候选人状态
                state = NodeState.CANDIDATE;
                logger.info("当前节点状态改变为" + state);
            }
        }, heartbeatMaxTime);
    }

    public static void heartbeatTimerUpdate(){
        timer.cancel();
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //超时, 当前节点切换为候选人状态,
                state = NodeState.CANDIDATE;
                logger.info("当前节点状态改变为" + state);
            }
        }, heartbeatMaxTime);
    }


    //对于节点建立rpc连接,建立线程,初始化拓扑
    // todo:进一步完善,目前实现仅方便测试
    public void buildRpc(NodeInfo nodeInfo) {
        if (!clientChannels.contains(nodeInfo))
            clientChannels.put(nodeInfo, new FedRaftClient(nodeInfo.getIp(), nodeInfo.getPort()));
        if (!topologies.contains(nodeInfo))
            topologies.put(nodeInfo, 1000.0f);
        System.out.println(clientChannels);
        System.out.println(topologies);
    }

    public static NodeState getState() {
        return state;
    }

    public static void setState(NodeState newState) {
        switch (newState) {
            case TMP_LEADER: // tmp leader只能从 safe mode转换来
                if (state == NodeState.SAFE_MODE) {
                    break;
                }
            case LEADER:
                if (state == NodeState.CANDIDATE) {
                    break;
                }
            case CANDIDATE:
                if (state == NodeState.CANDIDATE || state == NodeState.FOLLOWER) {
                    break;
                }
            case SAFE_MODE:  // safe mode只有初始化时才会有这种状态
                throw new StateChangeException("invalid state change from " + state + " to " + newState);

        }
        state = newState;
    }


    public static void main(String[] args) {
        Node leader = new Node();
        leader.buildRpc(new NodeInfo(Configuration.getString(Configuration.MANAGER_SERVER_HOST), Configuration.getInt(Configuration.MANAGER_SERVER_PORT), Configuration.getInt(Configuration.TRAINER_SERVER_PORT)));//传入客户端信息
        leader.maintainHeartbeat();
        try {
            sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //关闭线程池
        executor.shutdown();
    }
}
