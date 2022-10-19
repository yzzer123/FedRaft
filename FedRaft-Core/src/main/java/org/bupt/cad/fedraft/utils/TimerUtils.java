package org.bupt.cad.fedraft.utils;

import com.ifesdjeen.timer.HashedWheelTimer;
import com.ifesdjeen.timer.WaitStrategy;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TimerUtils {


    private static final HashedWheelTimer timer;

    static {
        timer = new HashedWheelTimer("fedraft-manager-timer", TimeUnit.MICROSECONDS.toNanos(10), 10
                , new WaitStrategy.BusySpinWait()
                , Executors.newFixedThreadPool(10));
    }

    public static HashedWheelTimer getTimer() {
        return timer;
    }
}
