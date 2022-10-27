package org.bupt.cad.fedraft.server;

import java.io.IOException;

public class HeartbeatFollowerTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        ManagerServer server = new ManagerServer("127.0.0.1", 16788);
        server.start();

    }
}
