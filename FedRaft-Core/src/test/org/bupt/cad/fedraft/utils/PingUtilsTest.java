package org.bupt.cad.fedraft.utils;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.UnknownHostException;

public class PingUtilsTest {
    private static final Logger logger = LoggerFactory.getLogger(PingUtilsTest.class);

    @Test
    public void getDelayFromPing() {
//        for (int i = 0; i < 1; i++) {
        int delay = PingUtils.getDelayFromPing("64 bytes from 114.114.114.114: icmp_seq=3 ttl=76 time=36.987 ms");
        System.out.println(delay);
        delay = PingUtils.getDelayFromPing("64 bytes from 114.114.114.114: icmp_seq=8 ttl=76 time=24.1 ms");
        System.out.println(delay);
        delay = PingUtils.getDelayFromPing("Reply from 122.56.77.17: bytes=32 time=15ms TTL=247");
        System.out.println(delay);
        delay = PingUtils.getDelayFromPing("64 bytes from 110.242.68.66: icmp_seq=62466 ttl=44 time=-2314885529152986021888.000 ms (DUP!)");
        System.out.println(delay);
//            System.out.println(PingUtils.ping("10.112.195.22"));
//        }
    }

    @Test
    public void isPortAvailable() throws UnknownHostException {
        System.out.println(PingUtils.isPortAvailable(88));
    }

    @Test
    public void ping() throws IOException, InterruptedException {

//        new Timer().schedule(new TimerTask() {
//            @Override
//            public void run() {
//                try {
//                    logger.info("delay=\t" + PingUtils.ping("114.114.114.114"));
//                } catch (UnknownHostException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }, 0, 100);


        while (true) {

            logger.info("delay=\t" + PingUtils.ping("114.114.114.114"));
            Thread.sleep(100);
        }

//        // 定时ping
//        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
//
//
//        executorService.scheduleAtFixedRate(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    logger.info("delay=\t" + PingUtils.ping("114.114.114.114"));
//                } catch (UnknownHostException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }, 0, 100, TimeUnit.MILLISECONDS);
//        new CountDownLatch(1).await(1000, TimeUnit.SECONDS);
    }


}