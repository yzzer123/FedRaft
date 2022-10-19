package org.bupt.cad.fedraft.beans;

import org.junit.Test;

import java.net.UnknownHostException;

public class RuntimeInfoTest {

    @Test
    public void modTest() throws UnknownHostException {
        NodeInfo node = new NodeInfo("127.0.0.1", 16777, 16799);
        long id = node.getNodeId();
        NodeInfo nodeInfo = new NodeInfo(id);
        System.out.println(nodeInfo);
    }

}