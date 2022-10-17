package org.bupt.cad.fedraft.server;

import org.bupt.cad.fedraft.beans.NodeInfo;
import org.bupt.cad.fedraft.config.Configuration;
import org.bupt.cad.fedraft.node.Node;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class FedRaftServerTest {
    private FedRaftServer server;

    @Before
    public void setUp() throws Exception {
        server = new FedRaftServer(Configuration.getString(Configuration.MANAGER_SERVER_HOST), Configuration.getInt(Configuration.MANAGER_SERVER_PORT));
    }

    @Test
    public void testScheduledPing() {
        Map<Long, Integer> topology = Node.getRuntimeNode().getTopology();
        // 10.128.167.92
        synchronized (Node.getRuntimeNode().getTopology()) {
            topology.put(new NodeInfo("10.128.167.92", 16777, 16888).getNodeId(), -1);
            topology.put(new NodeInfo("10.112.195.22", 16777, 16888).getNodeId(), -1);
            topology.put(new NodeInfo("10.28.221.81", 16777, 16888).getNodeId(), -1);
        }
    }


    @After
    public void tearDown() throws Exception {
        server.start();
        server.blockUtilShutdown();
    }


}