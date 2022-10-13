package org.bupt.cad.fedraft.node;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bupt.cad.fedraft.beans.NodeInfo;
import org.bupt.cad.fedraft.config.Configuration;
import org.bupt.cad.fedraft.exception.StateChangeException;
import org.bupt.cad.fedraft.server.Candidate;
import org.bupt.cad.fedraft.server.FedRaftServer;
import org.bupt.cad.fedraft.utils.ClientPool;
import org.bupt.cad.fedraft.utils.ZkClient;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;


public class Node {
    private static final Logger logger = LogManager.getLogger(FedRaftServer.class.getName());

    private static final Node instance;

    static {
        instance = new Node();
    }


    public static Node getRuntimeNode() {
        return instance;
    }

    //自身节点的信息
    private final NodeInfo selfNodeInfo =
            new NodeInfo(Configuration.getString(Configuration.MANAGER_SERVER_HOST), Configuration.getInt(Configuration.MANAGER_SERVER_PORT), Configuration.getInt(Configuration.TRAINER_SERVER_PORT));
    //该节点保存的时延信息
    private final HashMap<Long, Integer> topologies = new HashMap<>();
    //保存的与其他所有节点的rpc连接
    private final ClientPool clientPool = new ClientPool();
    //定时线程池
    private final ExecutorService threadPool
            = Executors.newFixedThreadPool(Configuration.getInt(Configuration.NODE_THREADPOOL_NUMBERS));
    private int term = -1;//当前节点的任期
    private AtomicInteger delay = new AtomicInteger(-1);//当前节点的平均时延 todo:开启计时器定时获取delay值

    private final Long heartbeatMaxTime = Configuration.getLong(Configuration.NODE_HEARTBEAT_MAX_TIME);


    // 刚开始为安全模式
    private NodeState state = NodeState.SAFE_MODE;//candidate follower leader tmp_leader  safemode
    private final ZkClient zkClient = new ZkClient(selfNodeInfo);
    // 收到一次全局拓扑后，就会脱离安全模式

    private NodeMode nodeMode = new SafeModeNode();

    private void setNodeMode(NodeMode nodeMode) {
        this.nodeMode = nodeMode;
    }

    public <T extends NodeMode> T getNodeMode() {
        return (T) nodeMode;
    }

    public NodeInfo getSelfNodeInfo() {
        return selfNodeInfo;
    }

    public HashMap<Long, Integer> getTopologies() {
        return topologies;
    }

    public void releaseTopologies() {

    }

    public ClientPool getClientPool() {
        return clientPool;
    }

    public ExecutorService getThreadPool() {
        return threadPool;
    }

    public int getTerm() {
        return term;
    }

    public Node setTerm(int term) {
        if (term < this.term) {
            logger.error("term can't be reduced");
            throw new RuntimeException("term can't be reduced");
        }
        this.term = term;
        return this;
    }

    public void addTerm() {
        this.term++;
    }

    public int getDelay() {
        return delay.get();
    }

    public Node setDelay(int delay) {
        this.delay.set(delay);
        return this;
    }

    public ZkClient getZkClient() {
        return zkClient;
    }

    //初始化计时器
    public void resetHeartbeatTimer() {
//        if (timer != null) {
//            timer.cancel();
//        }
//        timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                //超时, 当前节点切换为候选人状态
//                state = NodeState.CANDIDATE;
//                logger.info("当前节点状态改变为" + state);
//            }
//        }, heartbeatMaxTime);

    }


    public NodeState getState() {
        return state;
    }

    public void setState(NodeState newState) throws StateChangeException {
        switch (newState) {
            case TMP_LEADER: // tmp leader只能从 safe mode转换来
                if (state == NodeState.SAFE_MODE) {
                    setNodeMode(new TmpLeader());
                    break;
                }
                throw new StateChangeException("invalid state change from " + state + " to " + newState);
            case LEADER:
                if (state == NodeState.CANDIDATE) {
                    setNodeMode(new Leader());
                    break;
                }
                throw new StateChangeException("invalid state change from " + state + " to " + newState);
            case CANDIDATE:
                if (state == NodeState.CANDIDATE || state == NodeState.FOLLOWER) {
                    setNodeMode(new Candidate());
                    break;
                }
                throw new StateChangeException("invalid state change from " + state + " to " + newState);
            case FOLLOWER:
                setNodeMode(new Follower());
                break;
            case SAFE_MODE:  // safe mode只有初始化时才会有这种状态
                throw new StateChangeException("invalid state change from " + state + " to " + newState);

        }
        state = newState;
    }


}
