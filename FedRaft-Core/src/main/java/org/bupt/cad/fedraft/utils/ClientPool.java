package org.bupt.cad.fedraft.utils;

import org.bupt.cad.fedraft.beans.NodeInfo;
import org.bupt.cad.fedraft.server.FedRaftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ClientPool {

    private static final Logger logger = LoggerFactory.getLogger(ClientPool.class);
    private final ConcurrentHashMap<Long, FedRaftClient> clientChannels = new ConcurrentHashMap<>();


    public FedRaftClient getChannel(Long nodeId) {
        FedRaftClient client = clientChannels.get(nodeId);
        if (client == null) {
            logger.info("created new channel with {}:{}", NodeInfo.idToIp(nodeId), NodeInfo.idToPort(nodeId));
            client = new FedRaftClient(NodeInfo.idToIp(nodeId), NodeInfo.idToPort(nodeId));
            clientChannels.put(nodeId, client);
        }
        return client;
    }

    public FedRaftClient removeChannel(Long nodeId) {
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
