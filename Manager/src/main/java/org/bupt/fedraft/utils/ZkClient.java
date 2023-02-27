package org.bupt.fedraft.utils;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.framework.recipes.leader.LeaderSelector;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.utils.CloseableUtils;
import org.apache.zookeeper.CreateMode;
import org.bupt.fedraft.beans.NodeInfo;
import org.bupt.fedraft.config.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 与zookeeper 通信的客户端
 */
public class ZkClient {

    private static final Logger logger = LoggerFactory.getLogger(ZkClient.class);
    private final static String CLUSTER = "/cluster";
    private final CuratorFramework client;
    private final NodeInfo node;
    // 监听器缓存
    private PathChildrenCache watcherCache;
    private PathChildrenCacheListener listener;
    private LeaderSelector leaderSelector;
    private final CountDownLatch leaderFinishLatch = null;


    public ZkClient(NodeInfo nodeInfo) {

        // 从配置文件中读取默认配置 read zookeeper configuration from config file.
        this(nodeInfo, Configuration.getString(Configuration.ZOOKEEPER_HOSTS),
                Configuration.getInt(Configuration.ZOOKEEPER_RETRY_TIMES),
                Configuration.getInt(Configuration.ZOOKEEPER_TIMEOUT),
                Configuration.getString(Configuration.ZOOKEEPER_NAMESPACE), true);

    }

    public ZkClient(NodeInfo nodeInfo, boolean autoRegister) {

        // 从配置文件中读取默认配置 read zookeeper configuration from config file.
        this(nodeInfo, Configuration.getString(Configuration.ZOOKEEPER_HOSTS),
                Configuration.getInt(Configuration.ZOOKEEPER_RETRY_TIMES),
                Configuration.getInt(Configuration.ZOOKEEPER_TIMEOUT),
                Configuration.getString(Configuration.ZOOKEEPER_NAMESPACE), autoRegister);
    }

    public ZkClient(NodeInfo nodeInfo, String zkHosts, int retryTimes, int timeout, String namespace, boolean autoRegister) {
        this.node = nodeInfo;
        if (zkHosts == null) {
            // 判断zk配置项中节点地址是否错误 check whether zk hosts is valid TODO more detail checking
            logger.error("zookeeper.hosts configuration can not be null");
            throw new NullPointerException("zookeeper.hosts configuration can not be null");
        }

        // 创建通信客户端实例 create connection client instance
        this.client = CuratorFrameworkFactory.builder()
                .connectString(zkHosts)
                .retryPolicy(new ExponentialBackoffRetry(1000, retryTimes))
                .sessionTimeoutMs(timeout)
                .namespace(namespace)
                .connectionTimeoutMs(timeout)
                .build();

        // 建立连接 create connection session
        this.client.start();

        if (autoRegister) {
            try {
                register();
            } catch (Exception e) {
                logger.error("register node failed:\n" + e.getMessage(), e);
                System.exit(1);
            }
        }
    }


    /**
     * 在zk中注册节点
     */
    public void register() throws Exception {

        // 节点未注册过 就要先加入注册中的集群，由leader审核通过才算注册成功
        if (client.checkExists().creatingParentsIfNeeded().forPath(CLUSTER + "/" + node.toString()) == null) {
            client.create().withMode(CreateMode.PERSISTENT).forPath(CLUSTER + "/" + node);
        }

        // 注册过的节点才能建立alive状态
        logger.info("node registered in " + Configuration.getString(Configuration.ZOOKEEPER_NAMESPACE) + CLUSTER);
    }

    public void logout() throws Exception {
        client.delete().forPath(CLUSTER + "/" + node);
        logger.info("node deleted in " + Configuration.getString(Configuration.ZOOKEEPER_NAMESPACE) + CLUSTER);
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
            this.watcherCache = new PathChildrenCache(this.client, CLUSTER, true);
        }


        this.listener = (client, event) -> {
            String nodePath;
            switch (event.getType()) {

                // 添加节点
                case CHILD_ADDED:
                    if (logger.isDebugEnabled())
                        logger.debug("cluster node added\t" + event.getData());
                    nodePath = event.getData().getPath();
                    watcher.addNode(new NodeInfo(nodePath.substring(CLUSTER.length() + 1)));
                    break;
                // 减少节点
                case CHILD_REMOVED:
                    if (logger.isDebugEnabled())
                        logger.debug("cluster node removed\t" + event.getData());
                    nodePath = event.getData().getPath();
                    watcher.removeNode(new NodeInfo(nodePath.substring(CLUSTER.length() + 1)));
                    break;
                case INITIALIZED:
                    if (logger.isDebugEnabled())
                        logger.debug("cluster node removed\t" + event.getData());
                    List<NodeInfo> nodes = new ArrayList<>(event.getInitialData().size());
                    for (ChildData node : event.getInitialData()) {
                        nodes.add(new NodeInfo(node.getPath().substring(CLUSTER.length() + 1)));
                    }
                    watcher.initNodes(nodes);
            }
        };

        this.watcherCache.getListenable().addListener(this.listener);
        this.watcherCache.start(PathChildrenCache.StartMode.POST_INITIALIZED_EVENT);

        logger.info("cluster watcher has been set");
    }

    /**
     * 直接获取集群节点
     *
     * @return 集群节点
     * @throws Exception 通信失败
     */
    public List<NodeInfo> getCluster() throws Exception {
        List<String> nodes = client.getChildren().forPath(CLUSTER);

        ArrayList<NodeInfo> nodeInfos = new ArrayList<>(nodes.size());
        for (String node : nodes) {
            nodeInfos.add(new NodeInfo(node));
        }
        return nodeInfos;
    }

    /**
     * 删除集群节点监控 最好只有leader监控全局节点变化， 过多的watcher会导致zk的性能下降
     */
    public void deleteClusterWatcher() {
        if (this.watcherCache == null || this.listener == null) {
            logger.warn("watcher hasn't been initialized");
            return;
        }
        this.watcherCache.getListenable().removeListener(this.listener);
        try {
            this.watcherCache.close();
        } catch (IOException e) {
            logger.warn(e.getMessage());
        }
//        this.watcherCache.close();
        this.listener = null;
        logger.info("cluster watcher has been removed");
    }

    public void closeConnection() {
        if (client == null) {
            return;
        }
        deleteClusterWatcher();
        CloseableUtils.closeQuietly(client);
        logger.info("zookeeper connection closed");
    }


    public NodeInfo getNodeInfo() {
        return node;
    }


    /**
     * 集群节点变化的监听器
     */
    public interface ClusterWatcher {
        void addNode(NodeInfo nodeInfo);

        void removeNode(NodeInfo nodeInfo);

        void initNodes(List<NodeInfo> nodeInfos);

    }


}
