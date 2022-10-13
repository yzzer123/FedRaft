package org.bupt.cad.fedraft.utils;

import org.bupt.cad.fedraft.beans.NodeInfo;
import org.bupt.cad.fedraft.server.FedRaftClient;

import java.util.concurrent.ConcurrentHashMap;

public class ClientPool {

    private final ConcurrentHashMap<Long, FedRaftClient> clientChannels = new ConcurrentHashMap<>();


    public FedRaftClient getChannel(Long nodeId) {
        FedRaftClient client = clientChannels.get(nodeId);
        if (client == null) {
            client = new FedRaftClient(NodeInfo.idToIp(nodeId), NodeInfo.idToPort(nodeId));
            clientChannels.put(nodeId, client);
        }
        return client;
    }
}
