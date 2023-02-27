package org.bupt.cad.fedraft.utils;


import com.ifesdjeen.timer.HashedWheelTimer;
import com.ifesdjeen.timer.WaitStrategy;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;


public class TimerUtilsTest {

    private static final Logger logger = LoggerFactory.getLogger(TimerUtilsTest.class);

    private HashedWheelTimer timer;
    private final CountDownLatch finished = new CountDownLatch(1);


    @Before
    public void setUp() throws Exception {
//        timer = new HashedWheelTimer(5, TimeUnit.MILLISECONDS);
        timer = new HashedWheelTimer("timer", TimeUnit.MICROSECONDS.toNanos(10), 10
                , new WaitStrategy.BusySpinWait()
                , Executors.newFixedThreadPool(5));
//        timer
//        timer.start();
    }


    @Test
    public void addTimeoutTask() {

        ScheduledFuture<?> timeout = timer.schedule(new Runnable() {
            @Override
            public void run() {
                logger.info("timeout");
                finished.countDown();
            }
        }, 100, TimeUnit.MILLISECONDS);
        logger.info("begin tick");


        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            timeout.cancel(true);
            finished.countDown();
        }

    }


    @Test
    public void addScheduledTask() {

        ScheduledFuture<?> timeout = timer.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                logger.info("done");
            }
        }, 0, 100, TimeUnit.MILLISECONDS);
        logger.info("begin tick");


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            timeout.cancel(true);
            finished.countDown();
        }

        logger.info("begin tick");
    }

    @After
    public void tearDown() throws Exception {
        finished.await();
//        timer.stop();
        timer.shutdown();
    }

}