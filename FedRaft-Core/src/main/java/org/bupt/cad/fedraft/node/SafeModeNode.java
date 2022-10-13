package org.bupt.cad.fedraft.node;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bupt.cad.fedraft.server.FedRaftServer;
import org.bupt.cad.fedraft.utils.ZkClient;

import java.util.Map;

//SAFE_MODE
public class SafeModeNode extends NodeMode {

    private static final Logger logger = LogManager.getLogger(FedRaftServer.class.getName());


    public void checkinTmpLeader() {

        Node runtimeNode = Node.getRuntimeNode();
        runtimeNode.getZkClient().checkinTmpLeader(new ZkClient.LeaderWatcher() {
            @Override
            public void takeLeadership() {
                //争抢成功, 切换节点状态, 并唤醒tmp_leader
                runtimeNode.setState(NodeState.TMP_LEADER);
                runtimeNode.addTerm();
                logger.info("tmp leader is" + runtimeNode.getZkClient().getNodeName());
                runtimeNode.setState(NodeState.TMP_LEADER);
            }
        });
    }

    //检查拓扑是否更新为全局拓扑
    public boolean checkTopologyDelay() {
        for (Map.Entry<Long, Integer> entry : Node.getRuntimeNode().getTopologies().entrySet()) {
            if (entry.getValue() < 0) {
                return false;
            }
        }
        return true;
    }

}
