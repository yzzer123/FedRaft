package org.bupt.cad.fedraft.server;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HeartbeatLeaderTest {


    private ManagerServer server;

    @Before
    public void setup() throws InterruptedException {
        server = new ManagerServer("127.0.0.1", 16788);
        server.start();
    }


    @Test
    public void testHeartBeat() {
//        Runtime leader = new Runtime();
//        leader.buildRpc(new NodeInfo("127.0.0.1", 16788, 1));//传入Follower信息
//        leader.maintainHeartbeat();
//        try {
//            sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //关闭线程池
        //Runtime.executor.shutdown();
    }

    @After
    public void shutdown() throws InterruptedException {
        server.blockUtilShutdown();
    }


}
