package org.bupt.fedraft.utils;

import org.bupt.fedraft.beans.NodeInfo;
import org.bupt.fedraft.config.Configuration;
import org.bupt.fedraft.state.ManagerState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
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

    public static final int INVALID_DELAY = 2000000;
    private static final Logger logger = LoggerFactory.getLogger(NetworkUtils.class);
    private static final Pattern delayPattern = Pattern.compile("time=([-+]?[0-9]*\\.?[0-9]+)");

    private static ManagerState managerState;

    private static ExecutorService threadPool;

    private static Long selfId;

    /**
     * 负责定时测试点到点延时 并计算出节点的平均时延
     */
    public static ScheduledFuture<?> startScheduledPingTask(ManagerState managerState) {

        if (NetworkUtils.managerState == null) {
            NetworkUtils.managerState = managerState;
            NetworkUtils.threadPool = managerState.getThreadPool();
            NetworkUtils.selfId = managerState.getSelfNodeInfo().getNodeId();
        }
        int heartbeatInterval = Configuration.getInt(Configuration.MANAGER_HEARTBEAT_TIME_INTERVAL);
        return TimerUtils.getTimer().scheduleAtFixedRate(NetworkUtils::pingTopology,
                0, heartbeatInterval / 2, TimeUnit.MILLISECONDS);
    }

    public static void pingTopology() {

        List<Long> hosts = new ArrayList<>();

        managerState.getTopology(list -> {
            list.forEach(tuple -> {
                hosts.add(tuple.getLeft());
            });
        });

        int avgDelay = pingTopologyByCMD(hosts);
        managerState.setDelay(avgDelay);
    }


    private static int pingTopologyByCMD(List<Long> hosts) {

        AtomicInteger sumOfDelay = new AtomicInteger(0);
        final CountDownLatch countDownLatch;

        int size = hosts.size();

        if (size < 1) {
            return INVALID_DELAY;
        }

        size--;
        countDownLatch = new CountDownLatch(size);

        for (Long clientId : hosts) {
            if (clientId.equals(selfId)) {
                continue;
            }
            threadPool.submit(() -> {
                // 对于未知的ip或者ping不通的都加上一个惩罚时延
                int delay = INVALID_DELAY;
                try {
                    delay = ping(NodeInfo.idToIp(clientId));
                } catch (IOException e) {
                    delay = INVALID_DELAY;
                    logger.warn(e.getMessage());
                } finally {
                    sumOfDelay.addAndGet(delay);
                    countDownLatch.countDown();
                }
            });
        }

        // 等待线程都结束
        try {
            countDownLatch.await();
        } catch (Exception e) {
            return INVALID_DELAY;
        }

        // 计算平均时延
        return sumOfDelay.get() / size;
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
            String line;
            int delay;
            while ((line = in.readLine()) != null) {
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
//            bindPort(InetAddress.getLocalHost().getHostAddress(), port);
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
