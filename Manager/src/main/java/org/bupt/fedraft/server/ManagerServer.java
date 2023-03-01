package org.bupt.fedraft.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.bupt.fedraft.beans.NodeInfo;
import org.bupt.fedraft.beans.Tuple;
import org.bupt.fedraft.config.Configuration;
import org.bupt.fedraft.state.ManagerState;
import org.bupt.fedraft.utils.NetworkUtils;
import org.bupt.fedraft.utils.ServerInfoUtil;
import org.bupt.fedraft.utils.TimerUtils;
import org.bupt.fedraft.utils.ZkClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class ManagerServer {

    private static final Logger logger = LoggerFactory.getLogger(ManagerServer.class);
    private final Server server;

    private final ZkClient zkClient;
    private final ManagerState managerState;

    public ManagerServer(String host, int port) {

        managerState = new ManagerState(host, port);
        zkClient = new ZkClient(managerState.getSelfNodeInfo());

        this.server = ServerBuilder.forPort(port)
                .maxInboundMessageSize(536870912)
                .executor(new ThreadPoolExecutor(
                        Configuration.getInt(Configuration.MANAGER_SERVER_MIN_THREAD_NUM),
                        Configuration.getInt(Configuration.MANAGER_SERVER_MAX_THREAD_NUM),
                        3, TimeUnit.SECONDS, new LinkedBlockingDeque<>()))
                .addService(new ManagerService(managerState))
                .addService(new JobManagerService(managerState))
                .build();
    }

    public static void main(String[] args) throws Exception {

        // 构建参数读取工具
        DefaultParser defaultParser = new DefaultParser();
        Options options = new Options();
        options.addOption("p", "port", true, "port for server");
        options.addOption("h", "host", true, "host for server");
        options.addOption("config", "config", true, "config file for server");
        options.addOption("zk", "zk", true, "cmd on zookeeper register");
        CommandLine cmd = null;
        try {
            cmd = defaultParser.parse(options, args);
        } catch (ParseException e) {
            logger.error("参数错误" + e.getMessage(), e);
            System.exit(1);
        }


        //  读取配置文件路径
        if (cmd.hasOption("config")) {
            Configuration.setConfigFile(cmd.getOptionValue("config"));
        }

        // 命令行中如果有参数就以命令行为准     优先级 命令行 > 自定义配置文件 > 默认配置文件
        if (cmd.hasOption("p")) {
            // 覆盖配置项port
            Configuration.set(Configuration.MANAGER_SERVER_PORT, Integer.parseInt(cmd.getOptionValue("p")));
        }


        if (cmd.hasOption("h")) {
            // 覆盖配置项host
            Configuration.set(Configuration.MANAGER_SERVER_HOST, cmd.getOptionValue("h"));

        }

        if (cmd.hasOption("zk")) {
            String zkCmd = cmd.getOptionValue("zk");

            ZkClient client = new ZkClient(new NodeInfo(Configuration.getString(Configuration.MANAGER_SERVER_HOST),
                    Configuration.getInt(Configuration.MANAGER_SERVER_PORT)), false);

            if (zkCmd.equals("register")) {
                client.register();
            } else if (zkCmd.equals("logout")) {
                client.logout();
            } else {
                logger.warn("command error [-zk register | logout]");
            }

            client.closeConnection();

            return;
        }

        ManagerServer server = new ManagerServer(Configuration.getString(Configuration.MANAGER_SERVER_HOST), Configuration.getInt(Configuration.MANAGER_SERVER_PORT));
        server.start();
        server.blockUtilShutdown();
    }

    /**
     * 终止服务，并等待所有连接释放
     */
    public void stop() throws InterruptedException {
        if (server != null) {
            // graceful shutdown
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    /**
     * 服务启动后阻塞主线程直到服务停止
     */
    public void blockUtilShutdown() throws InterruptedException {
        if (server != null) {
            logger.info("server main thread blocking util server shutdown!");
            server.awaitTermination();
        }
    }

    /**
     * 向zookeeper注册服务
     */
    public void initialize() {
        logger.info("server started on {}:{}[ID:{}] with PID:{}", managerState.getSelfNodeInfo().getIp(),
                managerState.getSelfNodeInfo().getPort(),
                managerState.getSelfNodeInfo().getNodeId(),
                ServerInfoUtil.getPid());

        //  启动时先获取当前集群，构建拓扑
        managerState.updateTopology(topology -> {

            try {
                List<NodeInfo> cluster = zkClient.getCluster();
                logger.info("read cluster info from zk: {}", cluster.toString());
                for (NodeInfo node : cluster) {
                    topology.add(new Tuple<>(node.getNodeId(), 2000000));
                }
                if (topology.size() < 3) {
                    logger.error("cluster size < 3");
                    System.exit(1);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        // 启动follower的超时倒计时
        managerState.start();

        // Java进程宕机
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            logger.warn("shutdown gRPC server because JVM shutdown");
            try {
                TimerUtils.getTimer().shutdownNow();
                ManagerServer.this.stop();
                managerState.close();
                zkClient.closeConnection();
            } catch (InterruptedException e) {
                e.printStackTrace(System.err);
            }
            logger.warn("server shutdown");
        }));
    }

    /**
     * 启动tomcat服务
     */
    public void start() {

        try {
            server.start();
        } catch (IOException e) {

            // 服务器启动失败 可能是端口被占用
            logger.error("server start failed:" + e.getMessage(), e);
            System.exit(1);
        }


        // 设置定时计算时延
        NetworkUtils.startScheduledPingTask(managerState);
        logger.info("server started ping other nodes ");

        // 向zk注册本节点配置 并初始化内存中的节点状态
        initialize();
    }

}
