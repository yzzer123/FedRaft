package org.bupt.cad.fedraft.utils;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
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

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 与zookeeper 通信的客户端
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

    private final static String ALIVE_CLUSTER = "/alive_cluster/";
    private final static String REGISTERED_CLUSTER = "/registered/";
    private final static String REGISTERING_CLUSTER = "/registering/";
    private final static String TMP_LEADER = "/leader";

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
    private void registerNode() throws Exception {

        // 节点未注册过 就要先加入注册中的集群，由leader审核通过才算注册成功
//        if (this.client.checkExists().creatingParentsIfNeeded().forPath(REGISTERED_CLUSTER + nodeName) == null){
//            this.client.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath(REGISTERING_CLUSTER + nodeName);
//        }
        // 注册过的节点才能建立alive状态
        this.client.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).forPath(ALIVE_CLUSTER + nodeName);
        logger.info("node registered in /fedraft/cluster");
    }


    /**
     * 在zk中注销节点
     */
    private void quitNode() {

        try {
            this.client.delete().forPath("/cluster/" + nodeName);
            logger.info("node deleted in /fedraft/cluster");
        } catch (Exception e) {
            logger.error("delete register node failed:\n" + e.getMessage(), e);
        }
    }

    /**
     * 集群初始化时通过抢占来确定临时节点
     *
     * @param leaderWatcher 成功成为leader的回调
     */
    public void checkinTmpLeader(LeaderWatcher leaderWatcher) {

        this.leaderSelector = new LeaderSelector(this.client, TMP_LEADER, new LeaderSelectorListenerAdapter() {
            @Override
            public void takeLeadership(CuratorFramework client) throws Exception {

                leaderWatcher.takeLeadership();

                leaderFinishLatch.await();
            }
        });
        this.leaderSelector.setId(nodeName);
        this.leaderFinishLatch = new CountDownLatch(1);
        this.leaderSelector.start();

    }




    /**
     * 放弃leader
     */
    public void giveUpCheckinLeader() {
        if (this.leaderSelector == null)
            return;
        this.leaderFinishLatch.countDown();
        this.leaderSelector.close();
        this.deleteClusterWatcher();
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

        this.listener = (client, event) -> {
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
            }
        };

        this.watcherCache.getListenable().addListener(this.listener);
        this.watcherCache.start();

        logger.info("cluster watcher has been set");
    }

    /**
     * 删除集群节点监控 最好只有leader监控全局节点变化， 过多的watcher会导致zk的性能下降
     */
    private void deleteClusterWatcher() {
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
    public interface ClusterWatcher {
        void addNode(NodeInfo nodeInfo);

        void removeNode(NodeInfo nodeInfo);

        void initNodes(List<NodeInfo> nodeInfos);

    }

    public interface LeaderWatcher {
        void takeLeadership();
    }
}
