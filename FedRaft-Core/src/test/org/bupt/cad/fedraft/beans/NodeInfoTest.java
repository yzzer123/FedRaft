package org.bupt.cad.fedraft.beans;

import org.junit.Test;

public class NodeInfoTest {

    @Test
    public void modTest() {
        NodeInfo node = new NodeInfo("127.0.0.1", 16777);
        long id = node.getNodeId();
        NodeInfo nodeInfo = new NodeInfo(id);
        System.out.println(nodeInfo);
    }

}