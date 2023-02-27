package org.bupt.fedraft.utils;

import org.bupt.fedraft.beans.NodeInfo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ZkClientTest {
    private static final Logger logger = LoggerFactory.getLogger(ZkClientTest.class);
    private ZkClient client;

    @Before
    public void setUp() throws Exception {
        client = new ZkClient(new NodeInfo("127.0.0.1", 1799));

        client.setClusterWatcher(new ZkClient.ClusterWatcher() {
            @Override
            public void addNode(NodeInfo nodeInfo) {
                logger.info("add node:" + nodeInfo.toString());
            }

            @Override
            public void removeNode(NodeInfo nodeInfo) {
                logger.info("remove node:" + nodeInfo.toString());
            }

            @Override
            public void initNodes(List<NodeInfo> nodeInfos) {
                logger.info("init nodes list: " + nodeInfos);
            }
        });

    }

    @Test
    public void sleep() throws InterruptedException {
        Thread.sleep(300000);
    }

    @After
    public void tearDown() throws Exception {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            client.closeConnection();
        }));
    }
}