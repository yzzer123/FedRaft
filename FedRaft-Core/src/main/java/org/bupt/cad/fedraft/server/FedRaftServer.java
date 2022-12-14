package org.bupt.cad.fedraft.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.bupt.cad.fedraft.algorithm.RaftAlgorithm;
import org.bupt.cad.fedraft.config.Configuration;
import org.bupt.cad.fedraft.node.Runtime;
import org.bupt.cad.fedraft.utils.PingUtils;
import org.bupt.cad.fedraft.utils.ZkClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;


public class FedRaftServer {

    private static final Logger logger = LoggerFactory.getLogger(FedRaftServer.class);
    private final Server server;
    private final String host;
    private final int port;

    private ZkClient zkClient;

    public FedRaftServer(String host, int port) {
        this.host = host;
        this.port = port;
        this.server = ServerBuilder.forPort(port)
                .addService(new FedRaftService(new RaftAlgorithm())).build();
    }

    /**
     * 向zookeeper注册服务
     */
    public void initialize() {

        Runtime runtime = Runtime.getRuntime();
        zkClient = runtime.getZkClient();
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
        logger.info("server started on {}:{} ", host, port);

        // 向zk注册本节点配置 并初始化内存中的节点状态
        initialize();

        // 设置定时计算时延
        ScheduledFuture<?> scheduledPingFuture = PingUtils.startScheduledPingTask();
        // 设置定时和trainer同步


        logger.info("server began to ping other nodes ");

        // Java进程宕机
        java.lang.Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                logger.error("trying to shutdown gRPC server because JVM shutdown");
                try {
                    scheduledPingFuture.cancel(true);

                    FedRaftServer.this.stop();
                    zkClient.closeConnection();
                } catch (InterruptedException e) {
                    e.printStackTrace(System.err);
                }
                logger.error("server has shutdown");
            }
        });
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
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 构建参数读取工具
        DefaultParser defaultParser = new DefaultParser();
        Options options = new Options();
        options.addOption("p", "port", true, "port for server");
        options.addOption("h", "host", true, "host for server");
        options.addOption("config", "config", true, "config file for server");
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

        FedRaftServer server = new FedRaftServer(Configuration.getString(Configuration.MANAGER_SERVER_HOST), Configuration.getInt(Configuration.MANAGER_SERVER_PORT));
        server.start();
        server.blockUtilShutdown();
    }
}
