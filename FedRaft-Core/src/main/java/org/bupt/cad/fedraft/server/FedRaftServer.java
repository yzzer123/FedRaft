package org.bupt.cad.fedraft.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class FedRaftServer {

    private static final Logger logger = LogManager.getLogger(FedRaftServer.class);

    private final Server server;
    private final String host;
    private final int port;

    public FedRaftServer(String host, int port) {
        this.host = host;
        this.port = port;
        this.server = ServerBuilder.forPort(port)
                .addService(new FedRaftService()).build();
    }

    /**
     * 向zookeeper注册服务
     */
    public void initialize() {

    }

    /**
     * 启动tomcat服务
     */
    public void start() throws IOException {
        server.start();
        logger.info("server started on port " + port);

        // Java进程宕机
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.err.println("shutdown gRPC server because JVM shutdown");
                try {
                    FedRaftServer.this.stop();
                } catch (InterruptedException e) {
                    e.printStackTrace(System.err);
                }
                System.err.println("server shutdown");
            }
        });

        // 向zk注册本节点配置
        initialize();
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
    private void blockUtilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        // TODO 从配置文件中读取
        String host = "localhost";
        int port = 16778;

        // 命令行中如果有参数就以命令行为准
        if (args.length == 2) {
            host = args[0];
            port = Integer.parseInt(args[1]);
        }
        FedRaftServer server = new FedRaftServer("localhost", 16778);
        server.start();
        server.blockUtilShutdown();
    }
}
