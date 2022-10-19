package org.bupt.cad.fedraft.server;

import org.bupt.cad.fedraft.beans.NodeInfo;
import org.bupt.cad.fedraft.config.Configuration;
import org.bupt.cad.fedraft.node.Runtime;
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
        Map<Long, Integer> topology = Runtime.getRuntime().getTopology();
        // 10.128.167.92
        synchronized (Runtime.getRuntime().getTopology()) {
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