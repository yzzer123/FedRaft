package org.bupt.cad.fedraft.utils;

import org.bupt.cad.fedraft.beans.NodeInfo;
import org.bupt.cad.fedraft.node.fedraft.Runtime;
import org.bupt.cad.fedraft.server.ManagerClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ClientPool {

    private static final Logger logger = LoggerFactory.getLogger(ClientPool.class);
    private final ConcurrentHashMap<Long, ManagerClient> clientChannels = new ConcurrentHashMap<>();

    private final Runtime runtime;

    public ClientPool(Runtime runtime){
        this.runtime = runtime;
    }

    public ManagerClient getChannel(Long nodeId) {
        ManagerClient client = clientChannels.get(nodeId);
        if (client == null) {
            if (logger.isDebugEnabled()) {
                logger.debug("created new channel with {}", new NodeInfo(nodeId));
            }
            client = new ManagerClient(runtime, new NodeInfo(nodeId));
            clientChannels.put(nodeId, client);
        }
        return client;
    }

    public ManagerClient removeChannel(Long nodeId) {
        return clientChannels.remove(nodeId);
    }

    /**
     * 清除集合中的节点通信通道
     *
     * @param nodeSet 节点
     */
    public void removeChannels(Set<Long> nodeSet) {
        clientChannels.entrySet().removeIf(entry -> !nodeSet.contains(entry.getKey()));
    }

    public void clear() {
        clientChannels.clear();
    }
}
