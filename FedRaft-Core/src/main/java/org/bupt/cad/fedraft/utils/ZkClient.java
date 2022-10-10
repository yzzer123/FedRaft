package org.bupt.cad.fedraft.utils;


/**
 * 单例设计模式，全局只有一个实例
 */
public class ZkClient {

    final private static ZkClient instance;


    static {
        instance = new ZkClient();
    }

    public static ZkClient getInstance() {
        if (instance == null) {
            throw new NullPointerException("zkclient instance can not be null, it hasn't been initialized normally!");
        }
        return instance;
    }

    private ZkClient() {


    }

    /**
     * TODO 在zk中注册节点
     */
    public void registerNode() {

    }

    /**
     * TODO 设置集群节点的监控
     */
    public void setClusterWatcher() {

    }

    /**
     * TODO 删除集群节点监控 最好只有leader监控全局节点变化， 过多的watcher会导致zk的性能下降
     */
    public void deleteClusterWatcher() {

    }


}
