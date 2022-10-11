package org.bupt.cad.fedraft.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bupt.cad.fedraft.server.FedRaftServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetworkUtils {

    private static final Logger logger = LogManager.getLogger(FedRaftServer.class);
    private static final Pattern delayPattern = Pattern.compile("time=([-+]?[0-9]*\\.?[0-9]+)");

    /**
     * TODO 测试端到端时延，双向时延
     *
     * @param host 目标ip
     * @return 单次时延, 如果不可达 返回-1
     */
    public static int ping(String host) throws UnknownHostException {
        if (host == null) {
            throw new UnknownHostException("host invalid");
        }
        boolean isWindows = System.getProperty("os.name").toLowerCase().contains("win");
        String command = "ping " + host + (isWindows ? " -n 1 -w 1000" : " -c 1 -w 1000");
        BufferedReader in = null;
        try {
            Process process = Runtime.getRuntime().exec(command);
            in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = null;
            int delay = -1;
            while ((line = in.readLine()) != null) {
                logger.debug("get output from ping shell:\t" + line);
                delay = getDelayFromPing(line);
                if (delay != -1) break;
            }
//            process.destroy();
            return delay;
        } catch (Exception e) {
            logger.warn(e.getMessage(), e);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    logger.warn(e.getMessage(), e);
                }
            }
        }
        return -1;
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
