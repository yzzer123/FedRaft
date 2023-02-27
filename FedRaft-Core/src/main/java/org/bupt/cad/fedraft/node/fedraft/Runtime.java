package org.bupt.cad.fedraft.node.fedraft;


import org.bupt.cad.fedraft.beans.NodeInfo;
import org.bupt.cad.fedraft.beans.Tuple;
import org.bupt.cad.fedraft.config.Configuration;
import org.bupt.cad.fedraft.exception.StateChangeException;
import org.bupt.cad.fedraft.rpc.message.NodeState;
import org.bupt.cad.fedraft.server.ManagerClient;
import org.bupt.cad.fedraft.utils.ClientPool;
import org.bupt.cad.fedraft.utils.ZkClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * manager 运行时状态 做批量改变时需要对对象加锁 非线程安全，需要提前获取线程锁
 */
public class Runtime {

    private static final Logger logger = LoggerFactory.getLogger(Runtime.class);

    // 节点状态读写锁
    private final ReentrantReadWriteLock runtimeLock;
    // 拓扑读写锁
    private final ReentrantReadWriteLock topologyLock;


    //自身节点的信息
    private final NodeInfo selfNodeInfo;  //该节点保存的时延信息
    private final ConcurrentHashMap<Long, Tuple<Integer, Long>> topology;
    //保存的与其他所有节点的rpc连接
    private final ClientPool clientPool;
    private final ManagerClient trainerClient;
    //定时线程池
    private final ExecutorService threadPool;
    private int delay;//当前节点的平均时延
    private final ZkClient zkClient;
    private NodeInfo leaderInfo;
    private int term = 0;//当前节点的任期
    // 刚开始为安全模式 收到一次全局拓扑后，就会脱离安全模式
    private NodeState state;//candidate follower leader tmp_leader  safemode
    private Node nodeMode;
    // 模型索引
    private int modelIndex = 0;


    public Runtime() {
        // 建立读写锁
        runtimeLock = new ReentrantReadWriteLock(true);
        topologyLock = new ReentrantReadWriteLock(true);

        threadPool = new ThreadPoolExecutor(Configuration.getInt(Configuration.MANAGER_THREADPOOL_NUMBERS),
                2 * Configuration.getInt(Configuration.MANAGER_THREADPOOL_NUMBERS), 3, TimeUnit.SECONDS, new LinkedBlockingDeque<>());

        // 注册zk
        selfNodeInfo = new NodeInfo(Configuration.getString(Configuration.MANAGER_SERVER_HOST),
                Configuration.getInt(Configuration.MANAGER_SERVER_PORT), Configuration.getInt(Configuration.TRAINER_SERVER_PORT));
        zkClient = new ZkClient(selfNodeInfo);

        leaderInfo = null;


        // 初始化节点状态
        topology = new ConcurrentHashMap<>();
        clientPool = new ClientPool(this);

        trainerClient = new ManagerClient(this, selfNodeInfo, true);

        delay = -1;

        state = NodeState.SAFE_MODE;
        nodeMode = new SafeMode(this);

        if (logger.isDebugEnabled()){
            logger.debug("manager runtime initialized successfully!");
        }
    }


    public void lockRuntime(boolean isWrite) {
        if (isWrite){
            runtimeLock.writeLock().lock();
        }else {
            runtimeLock.readLock().lock();
        }
    }

    public void unlockRuntime(boolean isWrite) {
        if (isWrite){
            runtimeLock.writeLock().unlock();
        }else {
            runtimeLock.readLock().unlock();
        }
    }

    public void lockTopology(boolean isWrite) {
        if (isWrite){
            topologyLock.writeLock().lock();
        }else {
            topologyLock.readLock().lock();
        }
    }

    public void unlockTopology(boolean isWrite) {
        if (isWrite){
            topologyLock.writeLock().unlock();
        }else {
            topologyLock.readLock().unlock();
        }
    }


    public <T extends Node> T getNodeMode() {
        return (T) nodeMode;
    }

    private void setNodeMode(Node node) {
        this.nodeMode.close();
        this.nodeMode = node;
    }

    public NodeInfo getSelfNodeInfo() {
        return selfNodeInfo;
    }

    public Map<Long, Tuple<Integer, Long>> getTopology() {
        return topology;
    }


    public ClientPool getClientPool() {
        return clientPool;
    }

    public ManagerClient getTrainerClient() {
        return trainerClient;
    }

    public NodeInfo getLeaderInfo() {
        return leaderInfo;
    }

    public void setLeader(Long nodeId) {
        leaderInfo = (nodeId == null ? null : new NodeInfo(nodeId));
    }

    public ExecutorService getThreadPool() {
        return threadPool;
    }

    public int getTerm() {
        return term;
    }

    public Runtime setTerm(int term) {
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
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public ZkClient getZkClient() {
        return zkClient;
    }

    public NodeState getState() {
        return state;
    }

    public void setState(NodeState newState) throws StateChangeException {
        switch (newState) {
            case TMP_LEADER: // tmp leader只能从 safe mode转换来
                if (state == NodeState.SAFE_MODE) {
                    state = newState;
                    setNodeMode(new TmpLeader(this));
                    break;
                }
                throw new StateChangeException("invalid state change from " + state + " to " + newState);
            case LEADER:
                if (state == NodeState.CANDIDATE) {
                    state = newState;
                    setNodeMode(new Leader(this));
                    break;
                }
                throw new StateChangeException("invalid state change from " + state + " to " + newState);
            case CANDIDATE:
                if (state == NodeState.CANDIDATE || state == NodeState.FOLLOWER) {
                    state = newState;
                    // 传递选举状态
                    setNodeMode(new Candidate(this, ((Follower) nodeMode).getElectionExecutor()));
                    break;
                }
                throw new StateChangeException("invalid state change from " + state + " to " + newState);
            case FOLLOWER:
                state = newState;
                setNodeMode(new Follower(this));
                break;
            case SAFE_MODE:  // safe mode只有初始化时才会有这种状态
                throw new StateChangeException("invalid state change from " + state + " to " + newState);
        }
    }

    public int getModelIndex() {
        return modelIndex;
    }

    public void setModelIndex(int modelIndex) {
        this.modelIndex = modelIndex;
    }
}
