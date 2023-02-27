package org.bupt.fedraft.utils;

import com.ifesdjeen.timer.HashedWheelTimer;
import com.ifesdjeen.timer.WaitStrategy;
import org.bupt.fedraft.config.Configuration;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TimerUtils {


    private static final HashedWheelTimer timer;

    static {
        timer = new HashedWheelTimer("fedraft-manager-timer", TimeUnit.MICROSECONDS.toNanos(Configuration.getInt(Configuration.MANAGER_TIMER_TICK_TIME)), 256
                , new WaitStrategy.BusySpinWait()
                , Executors.newFixedThreadPool(Configuration.getInt(Configuration.MANAGER_TIMER_THREADPOOL_NUM)));
    }

    public static HashedWheelTimer getTimer() {
        return timer;
    }
}
