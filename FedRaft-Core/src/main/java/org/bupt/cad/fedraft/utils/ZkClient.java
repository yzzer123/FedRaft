package org.bupt.cad.fedraft.utils;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.framework.recipes.leader.LeaderSelector;
import org.apache.curator.framework.recipes.leader.LeaderSelectorListenerAdapter;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.utils.CloseableUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.zookeeper.CreateMode;
import org.bupt.cad.fedraft.beans.NodeInfo;
import org.bupt.cad.fedraft.config.Configuration;
import org.bupt.cad.fedraft.server.FedRaftServer;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * 单例设计模式，全局只有一个实例
 */
public class ZkClient {

    private static final Logger logger = LogManager.getLogger(FedRaftServer.class.getName());

    private final CuratorFramework client;

    // 监听器缓存
    private PathChildrenCache watcherCache;
    private PathChildrenCacheListener listener;

    private final String nodeName;

    private LeaderSelector leaderSelector;

    private CountDownLatch leaderFinishLatch = null;


    public ZkClient(NodeInfo nodeInfo) {
        this.nodeName = nodeInfo.toString();
        String zkClusterHosts = Configuration.getString(Configuration.ZOOKEEPER_HOSTS);
        if (zkClusterHosts == null) {
            // 判断zk配置项中节点地址是否错误
            logger.error("zookeeper.hosts configuration can not be null");
            throw new NullPointerException("zookeeper.hosts configuration can not be null");
        }

        // 创建通信客户端实例
        this.client = CuratorFrameworkFactory.builder()
                .connectString(zkClusterHosts)
                .retryPolicy(new ExponentialBackoffRetry(1000, Configuration.getInt(Configuration.ZOOKEEPER_RETRY_TIMES)))
                .sessionTimeoutMs(Configuration.getInt(Configuration.ZOOKEEPER_TIMEOUT))
                .namespace(Configuration.getString(Configuration.ZOOKEEPER_NAMESPACE))
                .build();

        // 建立连接
        this.client.start();
        try {
            registerNode();
        } catch (Exception e) {
            logger.error("register node failed:\n" + e.getMessage(), e);
            System.exit(1);
        }
    }


    /**
     * 在zk中注册节点
     */
    public void registerNode() throws Exception {

        this.client.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).forPath("/cluster/" + nodeName);
        logger.info("node registered in /fedraft/cluster");
    }


    /**
     * 在zk中注销节点
     */
    public void quitNode() {

        try {
            this.client.delete().forPath("/cluster/" + nodeName);
            logger.info("node deleted in /fedraft/cluster");
        } catch (Exception e) {
            logger.error("delete register node failed:\n" + e.getMessage(), e);
        }
    }

    /**
     * TODO 集群初始化时通过抢占来确定临时节点
     *
     * @param leaderWatcher 成功成为leader的回调
     */
    public void checkinTmpLeader(LeaderWatcher leaderWatcher) {
        String lockPath = "/leader";

        this.leaderSelector = new LeaderSelector(this.client, "/leader", new LeaderSelectorListenerAdapter() {
            @Override
            public void takeLeadership(CuratorFramework client) throws Exception {

                leaderWatcher.takeLeadership();

                leaderFinishLatch.await();
            }
        });
        this.leaderSelector.setId(nodeName);
        this.leaderFinishLatch = new CountDownLatch(1);
        this.leaderSelector.start();
        /*
            LeaderLatch leaderLatch = new LeaderLatch(this.client, "/leader", nodeName);
            leaderLatch.addListener(new LeaderLatchListener() {
                @Override
                public void isLeader() {
                    leaderWatcher.takeLeadership();
                }

                @Override
                public void notLeader() {
                    try {
                        leaderLatch.close();
                    } catch (IOException e) {
                        logger.warn(e.getMessage(), e);
                    }
                }
            });
        */
    }


    /**
     * 放弃leader
     */
    public void giveUpCheckinLeader() {
        if (this.leaderSelector == null)
            return;
        this.leaderFinishLatch.countDown();
        this.leaderSelector.close();
        this.leaderSelector = null;
    }


    /**
     * 设置集群节点的监控, 第一次设置就会触发一次
     * 如果已经有监听器，后续设置的监听器会覆盖原有的
     *
     * @param watcher 监听集群节点变化的监听器
     * @throws Exception 与zk集群通信失败的异常
     */
    public void setClusterWatcher(ClusterWatcher watcher) throws Exception {
        if (this.listener != null) {
            logger.warn("there has been a watcher!");
        }

        // 构造curator监听器
        if (this.watcherCache == null) {
            this.watcherCache = new PathChildrenCache(this.client, "/cluster", true);
        }

        this.listener = new PathChildrenCacheListener() {
            @Override
            public void childEvent(CuratorFramework client, PathChildrenCacheEvent event) throws Exception {
                String nodePath;
                String[] fields;
                switch (event.getType()) {

                    // 添加节点
                    case CHILD_ADDED:
                        logger.info("cluster node added\t" + event.getData());
                        nodePath = event.getData().getPath();
                        fields = nodePath.substring(9).split(":");
                        // /cluster/ip:port1:port2
                        watcher.addNode(new NodeInfo(fields[0], Integer.parseInt(fields[1]), Integer.parseInt(fields[2])));
                        break;
                    // 减少节点
                    case CHILD_REMOVED:
                        logger.info("cluster node removed\t" + event.getData());
                        nodePath = event.getData().getPath();
                        fields = nodePath.substring(9).split(":");
                        // /cluster/ip:port1:port2
                        watcher.removeNode(new NodeInfo(fields[0], Integer.parseInt(fields[1]), Integer.parseInt(fields[2])));
                        break;
//                        break;
                    // 初始化需要全量更新
//                    case INITIALIZED:
//                        logger.info("cluster information initialized");
//                        for (ChildData data : event.getInitialData()) {
//
//                        }
                }
            }
        };

        this.watcherCache.getListenable().addListener(this.listener);
        this.watcherCache.start();

        logger.info("cluster watcher has been set");
    }

    /**
     * 删除集群节点监控 最好只有leader监控全局节点变化， 过多的watcher会导致zk的性能下降
     */
    public void deleteClusterWatcher() throws IOException {
        if (this.watcherCache == null || this.listener == null) {
            logger.warn("watcher hasn't been initialized");
            return;
        }
        this.watcherCache.getListenable().removeListener(this.listener);
//        this.watcherCache.close();
        this.listener = null;
        logger.info("cluster watcher has been removed");
    }

    public void closeConnection() {
        if (client == null) {
            return;
        }
        // 如果是leader就要放弃主权
        giveUpCheckinLeader();
        CloseableUtils.closeQuietly(client);
        logger.info("zookeeper connection closed");
    }


    public String getNodeName() {
        return nodeName;
    }


    /**
     * 集群节点变化的监听器
     */
    interface ClusterWatcher {
        void addNode(NodeInfo nodeInfo);

        void removeNode(NodeInfo nodeInfo);

    }

    interface LeaderWatcher {
        void takeLeadership();
    }
}
