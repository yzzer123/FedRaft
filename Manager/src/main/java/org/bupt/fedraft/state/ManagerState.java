package org.bupt.fedraft.state;

import org.bupt.fedraft.beans.NodeInfo;
import org.bupt.fedraft.beans.Tuple;
import org.bupt.fedraft.config.Configuration;
import org.bupt.fedraft.job.manager.Follower;
import org.bupt.fedraft.server.ClientPool;
import org.bupt.fedraft.server.ManagerClient;
import org.bupt.fedraft.utils.ReadWriteObjWatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 统一保存Ping值等全局状态，保存维护的Job信息，能够维护若干个Job同时运行
 *
 * @author yzzer
 */
public class ManagerState {

    private static final Logger logger = LoggerFactory.getLogger(ManagerState.class);

    private final double JOB_CANDIDATE_RATE = Configuration.getDouble(Configuration.ELECTION_CANDIDATE_QUALIFY_RATE);

    private final AtomicInteger delay;

    private final ManagerRaftState raftState;

    private final ReentrantReadWriteLock topologyLock;

    private final ReentrantReadWriteLock managerStateLock;

    private final List<Tuple<Long, Integer>> topology;

    private final List<JobManager> jobStates;

    private final ReentrantReadWriteLock jobStatesLock;


    private final ExecutorService threadPool;
    private final ClientPool<ManagerClient> managerClientPool;

    private final NodeInfo selfNodeInfo;

    public ManagerState(String ip, int port) {
        delay = new AtomicInteger(0);

        topology = new ArrayList<>(100);

        topologyLock = new ReentrantReadWriteLock(true);
        managerStateLock = new ReentrantReadWriteLock(true);

        threadPool = new ThreadPoolExecutor(Configuration.getInt(Configuration.MANAGER_THREADPOOL_NUMBERS),
                2 * Configuration.getInt(Configuration.MANAGER_THREADPOOL_NUMBERS), 3,
                TimeUnit.SECONDS, new LinkedBlockingDeque<>());

        managerClientPool = new ClientPool<>(this, (managerState, id) -> new ManagerClient(managerState, new NodeInfo(id)));


        selfNodeInfo = new NodeInfo(ip, port);

        raftState = new ManagerRaftState();

        // 此时处于初始化状态，不会发生多线程访问
        raftState.job = new Follower(this, true);

        jobStates = new ArrayList<>(10);
        jobStatesLock = new ReentrantReadWriteLock(true);

        logger.info("ManagerState initialized");
    }

    private int getJobIndex(long sourceId, int uuid) {
        int i = 0;
        for (JobManager jobState : jobStates) {
            if (jobState.uuid == uuid && jobState.sourceId == sourceId) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /**
     * 获取任务状态
     *
     * @param sourceId 提交任务的源ID
     * @param uuid     唯一任务ID
     * @return 任务状态
     */
    public JobManager getJobState(long sourceId, int uuid) {
        JobManager jobState = null;
        jobStatesLock.readLock().lock();
        int index = getJobIndex(sourceId, uuid);
        if (index != -1) {
            jobState = jobStates.get(index);
        }
        jobStatesLock.readLock().unlock();
        return jobState;
    }

    /**
     * 添加任务
     *
     * @param jobState 任务状态
     * @return 是否添加成功
     */
    public boolean addJobState(JobManager jobState) {
        boolean isSuccess = false;

        jobStatesLock.writeLock().lock();
        if (getJobIndex(jobState.sourceId, jobState.uuid) == -1) {
            jobStates.add(jobState);
            isSuccess = true;
        }
        jobStatesLock.writeLock().unlock();
        return isSuccess;
    }

    /**
     * 删除任务状态
     *
     * @param sourceId 提交任务的源ID
     * @param uuid     唯一任务ID
     */
    public void deleteJobState(long sourceId, int uuid) {
        jobStatesLock.writeLock().lock();
        int index = getJobIndex(sourceId, uuid);
        JobManager jobState = getJobState(sourceId, uuid);
        if (jobState != null) {
            jobStates.remove(index);
            jobState.close();
        }
        jobStatesLock.writeLock().unlock();
    }

    public ExecutorService getThreadPool() {
        return threadPool;
    }


    public ClientPool<ManagerClient> getManagerClientPool() {
        return managerClientPool;
    }

    public NodeInfo getSelfNodeInfo() {
        return selfNodeInfo;
    }

    /**
     * 读取选举状态
     *
     * @param watcher 状态处理器
     */
    public void readRaftState(ReadWriteObjWatcher<ManagerRaftState> watcher) {
        managerStateLock.readLock().lock();
        watcher.work(raftState);
        managerStateLock.readLock().unlock();

    }

    /**
     * 更新选举状态
     *
     * @param watcher 状态处理器
     */
    public void updateRaftState(ReadWriteObjWatcher<ManagerRaftState> watcher) {
        managerStateLock.writeLock().lock();
        watcher.work(raftState);
        managerStateLock.writeLock().unlock();
    }

    /**
     * @return 获取本节点时延
     */
    public int getDelay() {
        return delay.get();
    }

    /**
     * 更新本节点时延
     *
     * @param newDelay 新的时延
     */
    public void setDelay(int newDelay) {
        delay.set(newDelay);
    }

    private int getTopologyIndex(Long id) {
        int i = 0;
        for (Tuple<Long, Integer> tuple : topology) {
            if (tuple.getLeft().equals(id)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /**
     * 获取某个节点的时延
     *
     * @param id 节点ID
     * @return 时延
     */
    public int getTopology(Long id) {
        int targetDelay = 2000000;
        topologyLock.readLock().lock();
        int index = getTopologyIndex(id);
        targetDelay = index == -1 ? targetDelay : topology.get(index).getRight();
        topologyLock.readLock().unlock();
        return targetDelay;
    }

    /**
     * 更新节点时延
     *
     * @param id       节点ID
     * @param newDelay 时延
     */
    public void updateTopology(Long id, int newDelay) {
        topologyLock.writeLock().lock();
        int index = getTopologyIndex(id);
        if (index != -1) {
            Tuple<Long, Integer> node = topology.get(index);
            // 平滑处理，避免时延摆动过大
            node.setRight(node.getRight() == 2000000 || newDelay == 2000000 ? newDelay : (node.getRight() * 3 + newDelay * 7) / 10);
            if (logger.isDebugEnabled()) {
                logger.debug("set node:{} delay with {}", new NodeInfo(id), node.getRight());
            }
        }
        topologyLock.writeLock().unlock();
    }

    /**
     * 节点注销后，在本地保存的拓扑中删除节点
     *
     * @param id 节点ID
     */
    public void deleteTopology(Long id) {
        topologyLock.writeLock().lock();
        int index = getTopologyIndex(id);
        if (index != -1) {
            topology.remove(index);
        }
        topologyLock.writeLock().unlock();
    }

    /**
     * 增加拓扑节点
     *
     * @param id 节点的ID
     */
    public void addTopology(Long id) {
        topologyLock.writeLock().lock();
        topology.add(new Tuple<>(id, 2000000));
        topologyLock.writeLock().unlock();
    }

    /**
     * 判断节点是否符合候选人要求（时延满足要求）
     *
     * @param id 节点ID
     * @return 判断结果
     */
    public boolean isQualifiedCandidate(Long id) {
        boolean result = false;
        topologyLock.readLock().lock();
        int qualifiedLine = (int) Math.ceil(JOB_CANDIDATE_RATE * topology.size());
        int delay = Integer.MIN_VALUE;

        // 统计小于节点时延的节点个数
        int count = 0;

        // 确定ID对应的时延
        for (Tuple<Long, Integer> delayTuple : topology) {
            if (delayTuple.getLeft().equals(id)) {
                delay = delayTuple.getRight();
                break;
            }
        }

        for (Tuple<Long, Integer> delayTuple : topology) {
            if (delay > delayTuple.getRight()) {
                count++;

                // 当超过qualifiedLine的数量的时延比该节点低的话，就认为该节点不能成为候选人
                if (count > qualifiedLine) {
                    break;
                }
            }
        }

        result = count <= qualifiedLine;

        topologyLock.readLock().unlock();
        return result;
    }

    /**
     * 判断自己能否成为Candidate
     *
     * @return 判断结果
     */
    public boolean isQualifiedCandidate() {
        return isQualifiedCandidate(selfNodeInfo.getNodeId());
    }


    /**
     * 拓扑进行批量读操作
     *
     * @param watcher 读处理器
     */
    public void getTopology(ReadWriteObjWatcher<List<Tuple<Long, Integer>>> watcher) {
        topologyLock.readLock().lock();
        watcher.work(topology);
        topologyLock.readLock().unlock();
    }

    /**
     * 对拓扑进行批量写操作
     *
     * @param watcher 写处理器
     */
    public void updateTopology(ReadWriteObjWatcher<List<Tuple<Long, Integer>>> watcher) {
        topologyLock.writeLock().lock();
        watcher.work(topology);
        topologyLock.writeLock().unlock();
    }

    public void start() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        raftState.job.resetTimer();
    }


    public void close() {
        for (JobManager jobState : jobStates) {
            jobState.close();
        }
        jobStates.clear();
        threadPool.shutdown();
        managerClientPool.close();
    }
}
