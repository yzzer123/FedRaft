package org.bupt.cad.fedraft.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bupt.cad.fedraft.beans.NodeInfo;
import org.bupt.cad.fedraft.utils.ZkClient;

import java.util.Map;
import java.util.Set;

//SAFE_MODE
public class SafeModeNode {

    private static final Logger logger = LogManager.getLogger(FedRaftServer.class.getName());


    public static boolean setClusterWatcher(){
        try {
            Node.zkClient.setClusterWatcher(new ZkClient.ClusterWatcher() {
                @Override
                public void addNode(NodeInfo nodeInfo) {
                    Node.topologies.putIfAbsent(nodeInfo.getNodeId(), 0);
                }

                @Override
                public void removeNode(NodeInfo nodeInfo) {
                    Node.topologies.remove(nodeInfo.getNodeId());
                }
            });
            return true;
        } catch (Exception e) {
//            e.printStackTrace();
            logger.error("设置监听器失败");
        }
        return false;

    }

    public static void checkinTmpLeader() {
        Node.zkClient.checkinTmpLeader(new ZkClient.LeaderWatcher() {
            @Override
            public void takeLeadership() {
                //争抢成功, 切换节点状态, 并唤醒tmp_leader
                Node.setState(NodeState.TMP_LEADER);
                Node.term += 1;
                logger.info("tmp leader is" + Node.zkClient.getNodeName());
                TmpLeader.init();
            }
        });
    }

    //检查拓扑是否更新为全局拓扑
    public static boolean checkLegal(){
        for(Map.Entry<Long, Integer> entry:Node.topologies.entrySet()){
            if(entry.getValue() == 0){
                return false;
            }
        }
        return true;
    }

}
