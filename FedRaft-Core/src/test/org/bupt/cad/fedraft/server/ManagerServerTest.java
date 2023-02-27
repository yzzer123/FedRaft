package org.bupt.cad.fedraft.server;

import org.bupt.cad.fedraft.beans.NodeInfo;
import org.bupt.cad.fedraft.beans.Tuple;
import org.bupt.cad.fedraft.config.Configuration;
import org.bupt.cad.fedraft.node.fedraft.Runtime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class ManagerServerTest {
    private ManagerServer server;

    @Before
    public void setUp() throws Exception {
        server = new ManagerServer(Configuration.getString(Configuration.MANAGER_SERVER_MAX_THREAD_NUM), Configuration.getInt(Configuration.MANAGER_SERVER_PORT));
    }

    @Test
    public void testScheduledPing() {
        Runtime runtime = new Runtime();
        Map<Long, Tuple<Integer, Long>> topology = runtime.getTopology();
        // 10.128.167.92
        synchronized (runtime.getTopology()) {
            topology.put(new NodeInfo("10.128.167.92", 16777, 16888).getNodeId(), new Tuple<>(-1, 0L));
            topology.put(new NodeInfo("10.112.195.22", 16777, 16888).getNodeId(), new Tuple<>(-1, 0L));
            topology.put(new NodeInfo("10.28.221.81", 16777, 16888).getNodeId(), new Tuple<>(-1, 0L));
        }
    }


    @After
    public void tearDown() throws Exception {
        server.start();
        server.blockUtilShutdown();
    }


}