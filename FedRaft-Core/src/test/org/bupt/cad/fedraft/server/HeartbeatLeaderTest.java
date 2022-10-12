package org.bupt.cad.fedraft.server;

import org.bupt.cad.fedraft.beans.NodeInfo;

import static java.lang.Thread.sleep;

public class HeartbeatLeaderTest {

    public static void main(String[] args) {
        Node leader = new Node();
        leader.buildRpc(new NodeInfo("127.0.0.1", 16788, 1));//传入Follower信息
        leader.maintainHeartbeat();
        try {
            sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //关闭线程池
        //Node.executor.shutdown();
    }

}
