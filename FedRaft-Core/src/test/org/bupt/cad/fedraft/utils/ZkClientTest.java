package org.bupt.cad.fedraft.utils;

import org.bupt.cad.fedraft.beans.NodeInfo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ZkClientTest {

    private ZkClient zkClient;
    private List<NodeInfo> nodeInfos = new ArrayList<>();
    private CountDownLatch finishLathch = new CountDownLatch(1);
    private HashMap<Long, ZkClient> clients = new HashMap<>();


    @Before
    public void init() {
        NodeInfo nodeInfo = new NodeInfo("127.0.0.1", 17888, 17999);
        clients.put(nodeInfo.getNodeId(), new ZkClient(nodeInfo));
        nodeInfo = new NodeInfo("127.0.0.2", 17888, 17999);
        clients.put(nodeInfo.getNodeId(), new ZkClient(nodeInfo));
        nodeInfo = new NodeInfo("127.0.0.3", 17888, 17999);
        clients.put(nodeInfo.getNodeId(), new ZkClient(nodeInfo));
        nodeInfo = new NodeInfo("127.0.0.1", 17777, 17666);
        clients.put(nodeInfo.getNodeId(), new ZkClient(nodeInfo));

        for (ZkClient client : clients.values()) {
            client.checkinTmpLeader(new ZkClient.LeaderWatcher() {
                @Override
                public void takeLeadership() {
                    System.out.println("leader is" + client.getNodeName());
                }
            });
        }

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println(nodeInfos);
            for (ZkClient value : clients.values()) {
                value.closeConnection();
            }
        }));
    }

    @Test
    public void testElection() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String cmd = scanner.next();
            if (cmd.equals("rm")) {
                NodeInfo nodeInfo = new NodeInfo(scanner.next(), scanner.nextInt(), scanner.nextInt());
                ZkClient removedClient = clients.remove(nodeInfo.getNodeId());
                removedClient.closeConnection();
            } else if (cmd.equals("new")) {
                NodeInfo nodeInfo = new NodeInfo(scanner.next(), scanner.nextInt(), scanner.nextInt());
                ZkClient newClient = new ZkClient(nodeInfo);
                clients.put(nodeInfo.getNodeId(), newClient);
                newClient.checkinTmpLeader(new ZkClient.LeaderWatcher() {
                    @Override
                    public void takeLeadership() {
                        System.out.println("leader is" + newClient.getNodeName());
                    }
                });
            }
            for (ZkClient client : clients.values()) {
                System.out.print(client.getNodeName() + ", ");
            }
            System.out.println();
            System.out.println("(rm/new host port1 port2)");
        }
    }

    @Test
    public void waitForShutdown() {
        try {
            finishLathch.await(10, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testAddWatcher() throws Exception {

        this.zkClient.setClusterWatcher(new ZkClient.ClusterWatcher() {

            @Override
            public void addNode(NodeInfo nodeInfo) {
                nodeInfos.add(nodeInfo);
                System.out.println(nodeInfo);
            }

            @Override
            public void removeNode(NodeInfo nodeInfo) {
                nodeInfos.remove(nodeInfo);
                System.out.println(nodeInfo);
            }
        });
        waitForShutdown();
    }

    @After
    public void close() {

        zkClient.closeConnection();
    }

    public static void main(String[] args) {
        ZkClientTest tester = new ZkClientTest();
        tester.init();
        tester.testElection();
        tester.close();
    }

}