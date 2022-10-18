package org.bupt.cad.fedraft.node;

import org.bupt.cad.fedraft.server.FedRaftServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TmpLeaderTest {

    private static final Logger logger = LoggerFactory.getLogger(TmpLeaderTest.class);

    private final String[] args;
    private FedRaftServer server;

    public TmpLeaderTest(String[] args) {
        this.args = args;
    }

    public static void main(String[] args) throws InterruptedException {
        FedRaftServer.main(args);
    }

    @Before
    public void setup() {
        server = new FedRaftServer(args[0], Integer.parseInt(args[1]));
        server.start();
    }

    @Test
    public void clusterSafeModeTest() {
    }

    @After
    public void tearDown() throws InterruptedException {
        server.blockUtilShutdown();

    }
}