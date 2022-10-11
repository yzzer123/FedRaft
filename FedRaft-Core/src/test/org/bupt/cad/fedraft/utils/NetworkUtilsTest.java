package org.bupt.cad.fedraft.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bupt.cad.fedraft.server.FedRaftServer;
import org.junit.Test;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class NetworkUtilsTest {
    private static final Logger logger = LogManager.getLogger(FedRaftServer.class);


    @Test
    public void getDelayFromPing() {
//        for (int i = 0; i < 1; i++) {
        int delay = NetworkUtils.getDelayFromPing("64 bytes from 114.114.114.114: icmp_seq=3 ttl=76 time=36.987 ms");
        System.out.println(delay);
        delay = NetworkUtils.getDelayFromPing("64 bytes from 114.114.114.114: icmp_seq=8 ttl=76 time=24.1 ms");
        System.out.println(delay);
        delay = NetworkUtils.getDelayFromPing("Reply from 122.56.77.17: bytes=32 time=15ms TTL=247");
        System.out.println(delay);
        delay = NetworkUtils.getDelayFromPing("64 bytes from 110.242.68.66: icmp_seq=62466 ttl=44 time=-2314885529152986021888.000 ms (DUP!)");
        System.out.println(delay);
//            System.out.println(NetworkUtils.ping("10.112.195.22"));
//        }
    }

    @Test
    public void isPortAvailable() throws UnknownHostException {
        System.out.println(NetworkUtils.isPortAvailable(88));
    }

    @Test
    public void ping() throws IOException, InterruptedException {

        // 定时ping
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    logger.info("delay=\t" + NetworkUtils.ping("114.114.114.114"));
                } catch (UnknownHostException e) {
                    throw new RuntimeException(e);
                }
            }
        }, 0, 100, TimeUnit.MILLISECONDS);
        new CountDownLatch(1).await(1000, TimeUnit.SECONDS);
    }


}