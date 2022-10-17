package org.bupt.cad.fedraft.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bupt.cad.fedraft.beans.NodeInfo;
import org.bupt.cad.fedraft.config.Configuration;
import org.bupt.cad.fedraft.node.Node;
import org.bupt.cad.fedraft.server.FedRaftServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 获取时延指标工具
 */
public class NetworkUtils {

    private static final Logger logger = LogManager.getLogger(FedRaftServer.class);
    private static final Pattern delayPattern = Pattern.compile("time=([-+]?[0-9]*\\.?[0-9]+)");
    private static final int INVALID_DELAY = 2000000;

    /**
     * 负责定时测试点到点延时 并计算出节点的平均时延
     */
    public static ScheduledFuture<?> startScheduledPingTask() {

        AtomicInteger delay = Node.getRuntimeNode().getDelay();
        int heartbeatInterval = Configuration.getInt(Configuration.NODE_HEARTBEAT_TIME_INTERVAL);
        return TimerUtils.getTimer().scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                logger.debug("begin scheduled ping");
                int avgDelay = pingTopology();
                delay.set(avgDelay);
                logger.debug("set delay = " + avgDelay);
            }
        }, heartbeatInterval, heartbeatInterval, TimeUnit.MILLISECONDS);
    }

    /**
     * 测试平均时延
     */
    public static int pingTopology() {
        Map<Long, Integer> topology = Node.getRuntimeNode().getTopology();
        ExecutorService threadPool = Node.getRuntimeNode().getThreadPool();
        List<Long> keyList;
        AtomicInteger sumOfDelay = new AtomicInteger(0);
        // 需要对拓扑加锁
        synchronized (Node.getRuntimeNode().getTopology()) {

            // 内存中没有拓扑，就将时延设置为-1
            if (topology.size() < 1) {
                return INVALID_DELAY;
            }
            // 在锁中读取拓扑集合
            keyList = new ArrayList<>(topology.keySet());
        }

        final CountDownLatch countDownLatch = new CountDownLatch(keyList.size());

        // 内存中有拓扑
        for (Long key : keyList) {
            String nodeIp = NodeInfo.idToIp(key);
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    // 对于未知的ip或者ping不通的都加上一个惩罚时延
                    int delay = INVALID_DELAY;
                    try {
                        delay = ping(nodeIp);
                    } catch (IOException e) {
                        delay = INVALID_DELAY;
                        logger.warn(e.getMessage());
                    } finally {
                        sumOfDelay.addAndGet(delay);
                        countDownLatch.countDown();
                    }
                }
            });// end method call

        }// end for

        // 等待线程都结束
        try {
            countDownLatch.await();
        } catch (Exception e) {
            return INVALID_DELAY;
        }

        logger.debug("total delay = " + sumOfDelay.get());
        // 计算平均时延
        return sumOfDelay.get() / keyList.size();
    }


    /**
     * 测试端到端时延，双向时延
     *
     * @param host 目标ip
     * @return 单次时延, 如果不可达 返回-1
     */
    public static int ping(String host) throws IOException {
        if (host == null) {
            throw new UnknownHostException("host invalid");
        }
        boolean isWindows = System.getProperty("os.name").toLowerCase().contains("win");
        String command = "ping " + host + (isWindows ? " -n 1 -w 1" : " -c 1 -w 1");
        BufferedReader in = null;
        try {
            Process process = Runtime.getRuntime().exec(command);
            in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = null;
            int delay = -1;
            while ((line = in.readLine()) != null) {
                logger.debug("get output from ping shell:\t" + line);
                delay = getDelayFromPing(line);
                if (delay != -1) {
                    return delay;
                }
            }
            throw new IOException(host + " host is unavailable");
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    logger.warn(e.getMessage(), e);
                }
            }
        }
    }


    /**
     * 检测端口占用情况
     */
    public static boolean isPortAvailable(int port) {
        try {
            bindPort("0.0.0.0", port);
            bindPort(InetAddress.getLocalHost().getHostAddress(), port);
            return true;
        } catch (Exception e) {
            logger.warn(port + " 端口被占用或无权限\t" + e.getMessage());
            return false;
        }
    }


    /**
     * 利用正则从一行中提取信息 如果没有提取到，就返回-1
     *
     * @param line ping的一行结果 如
     *             64 bytes from 114.114.114.114: icmp_seq=0 ttl=85 time=34.909 ms
     * @return 单位为 ms * 1000
     */
    public static int getDelayFromPing(String line) {
        int delay = -1;
        Matcher matcher = delayPattern.matcher(line);
        if (matcher.find()) {
            delay = (int) (Double.parseDouble(matcher.group().substring(5)) * 1000);

            // 延迟为负数就认为不可达
            if (delay < 0) delay = -1;
        }
        return delay;
    }

    /**
     * 用于测试端口占用
     */
    private static void bindPort(String host, int port) throws Exception {
        Socket s = new Socket();
        s.bind(new InetSocketAddress(host, port));
        s.close();
    }


}
