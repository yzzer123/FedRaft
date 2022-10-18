package org.bupt.cad.fedraft.node;


import org.bupt.cad.fedraft.beans.NodeInfo;
import org.bupt.cad.fedraft.config.Configuration;
import org.bupt.cad.fedraft.exception.StateChangeException;
import org.bupt.cad.fedraft.rpc.message.NodeState;
import org.bupt.cad.fedraft.server.FedRaftClient;
import org.bupt.cad.fedraft.utils.ClientPool;
import org.bupt.cad.fedraft.utils.ZkClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * manager 运行时状态 做批量改变时需要对对象加锁 非完全的线程安全
 */
public class Runtime {

    private static final Logger logger = LoggerFactory.getLogger(Runtime.class);
    private static final Runtime instance;

    static {
        instance = new Runtime();
    }

    //自身节点的信息
    private final NodeInfo selfNodeInfo =
            new NodeInfo(Configuration.getString(Configuration.MANAGER_SERVER_HOST), Configuration.getInt(Configuration.MANAGER_SERVER_PORT), Configuration.getInt(Configuration.TRAINER_SERVER_PORT));
    //该节点保存的时延信息
    private final ConcurrentHashMap<Long, Integer> topology = new ConcurrentHashMap<>();
    //保存的与其他所有节点的rpc连接
    private final ClientPool clientPool = new ClientPool();
    private final FedRaftClient trainerClient = new FedRaftClient(Configuration.getString(Configuration.MANAGER_SERVER_HOST), Configuration.getInt(Configuration.TRAINER_SERVER_PORT));
    //定时线程池
    private final ExecutorService threadPool
            = Executors.newFixedThreadPool(Configuration.getInt(Configuration.NODE_THREADPOOL_NUMBERS));
    private final AtomicInteger delay = new AtomicInteger(-1);//当前节点的平均时延 todo:开启计时器定时获取delay值
    private final Long heartbeatMaxTime = Configuration.getLong(Configuration.NODE_HEARTBEAT_MAX_TIME);
    private final ZkClient zkClient = new ZkClient(selfNodeInfo);
    private NodeInfo leaderInfo;
    private int term = -1;//当前节点的任期
    // 刚开始为安全模式 收到一次全局拓扑后，就会脱离安全模式
    private NodeState state = NodeState.SAFE_MODE;//candidate follower leader tmp_leader  safemode
    private Node node = new SafeMode();
    // 模型索引
    private int modelIndex = -1;


    private Runtime() {

    }

    public static Runtime getRuntime() {
        return instance;
    }

    public <T extends Node> T getNodeMode() {
        return (T) node;
    }

    private void setNodeMode(Node node) {
        this.node.close();
        this.node = node;
    }

    public NodeInfo getSelfNodeInfo() {
        return selfNodeInfo;
    }

    public ConcurrentHashMap<Long, Integer> getTopology() {
        return topology;
    }


    public ClientPool getClientPool() {
        return clientPool;
    }

    public FedRaftClient getTrainerClient() {
        return trainerClient;
    }

    public NodeInfo getLeaderInfo() {
        synchronized (this) {
            return leaderInfo;
        }
    }

    public void setLeader(Long nodeId) {
        synchronized (this) {
            leaderInfo = new NodeInfo(nodeId);
        }
    }

    public ExecutorService getThreadPool() {
        return threadPool;
    }

    public int getTerm() {
        synchronized (this) {
            return term;
        }
    }

    public Runtime setTerm(int term) {
        synchronized (this) {
            if (term < this.term) {
                logger.error("term can't be reduced");
                throw new RuntimeException("term can't be reduced");
            }
            this.term = term;
            return this;
        }
    }

    public void addTerm() {
        synchronized (this) {
            this.term++;
        }
    }

    public AtomicInteger getDelay() {
        return delay;
    }

    public ZkClient getZkClient() {
        return zkClient;
    }

    public NodeState getState() {
        synchronized (this) {
            return state;
        }
    }

    public void setState(NodeState newState) throws StateChangeException {
        switch (newState) {
            case TMP_LEADER: // tmp leader只能从 safe mode转换来
                if (state == NodeState.SAFE_MODE) {
                    state = newState;
                    setNodeMode(new TmpLeader());
                    break;
                }
                throw new StateChangeException("invalid state change from " + state + " to " + newState);
            case LEADER:
                if (state == NodeState.CANDIDATE) {
                    state = newState;
                    setNodeMode(new Leader());
                    break;
                }
                throw new StateChangeException("invalid state change from " + state + " to " + newState);
            case CANDIDATE:
                if (state == NodeState.CANDIDATE || state == NodeState.FOLLOWER) {
                    state = newState;
                    setNodeMode(new Candidate());
                    break;
                }
                throw new StateChangeException("invalid state change from " + state + " to " + newState);
            case FOLLOWER:
                state = newState;
                setNodeMode(new Follower());
                break;
            case SAFE_MODE:  // safe mode只有初始化时才会有这种状态
                throw new StateChangeException("invalid state change from " + state + " to " + newState);
        }
    }

    public int getModelIndex() {
        synchronized (this) {
            return modelIndex;
        }
    }

    public Runtime setModelIndex(int modelIndex) {
        synchronized (this) {
            this.modelIndex = modelIndex;
        }
        return this;
    }
}
