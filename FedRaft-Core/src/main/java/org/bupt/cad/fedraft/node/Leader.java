package org.bupt.cad.fedraft.node;

import org.bupt.cad.fedraft.config.Configuration;
import org.bupt.cad.fedraft.rpc.message.HeartbeatRequest;
import org.bupt.cad.fedraft.utils.ClientPool;
import org.bupt.cad.fedraft.utils.TimerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Leader extends Node {

    private static final Logger logger = LoggerFactory.getLogger(Leader.class);

    private final Map<Long, Integer> topology = Runtime.getRuntime().getTopology();
    private final ClientPool clientPool = Runtime.getRuntime().getClientPool();
    private ScheduledFuture<?> heartbeatTask;

    @Override
    public int receiveHeartbeat(HeartbeatRequest request) {
        return 0;
    }

    public Leader() {
        logger.info("{} became leader", Runtime.getRuntime().getSelfNodeInfo().getNodeId());
        Runtime.getRuntime().setLeader(Runtime.getRuntime().getSelfNodeInfo().getNodeId());
        maintainHeartbeat();

    }

    private void maintainHeartbeat() {

        int heartbeatInterval = Configuration.getInt(Configuration.NODE_HEARTBEAT_TIME_INTERVAL);
        logger.info("tmp leader begin maintainHeartbeat");

        // end runnable method
        heartbeatTask = TimerUtils.getTimer().scheduleAtFixedRate(this::heartbeatOnce, 10, heartbeatInterval, TimeUnit.MILLISECONDS);
    }


    private void heartbeatOnce() {

        HeartbeatRequest.Builder builder = HeartbeatRequest.newBuilder();

        Runtime runtime = Runtime.getRuntime();
        synchronized (Runtime.getRuntime()) {

            // 如果角色变化 就不能再发心跳
            if (runtime.getNodeMode() != this) {
                return;
            }

            builder = builder.setLeaderModelIndex(runtime.getModelIndex())
                    .setTerm(runtime.getTerm())
                    .setLeaderId(runtime.getSelfNodeInfo().getNodeId());

        }

        // 构造请求中的时延列表
        long selfId = runtime.getSelfNodeInfo().getNodeId();
        synchronized (Runtime.getRuntime().getTopology()) {

            logger.info("send topology = {}", topology);
            for (Map.Entry<Long, Integer> entry : topology.entrySet()) {
                builder.addNodeIds(entry.getKey());
                builder.addNetworkDelays(entry.getValue());
            }
        }

        HeartbeatRequest request = builder.build();

        // 发送的客户端
        List<Long> clientList = request.getNodeIdsList();

        for (Long clientId : clientList) {

            // 将自己排除掉
            if (clientId.equals(selfId)) {
                continue;
            }

            // 获取通信通道并发送心跳
            clientPool.getChannel(clientId).sendHeartBeat(request, response -> {
                int networkDelay = response.getNetworkDelay();

                // 更新心跳信息
                if (networkDelay > 0) {
                    topology.computeIfPresent(clientId, (k, v) -> networkDelay);
                }
            });// end method call
        }
    }


    @Override
    public void close() {
        if (heartbeatTask != null) {
            heartbeatTask.cancel(true);
        }
    }
}
