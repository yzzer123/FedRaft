package org.bupt.fedraft.utils;

public interface TimeoutKeeper {

    void resetTimeoutTask();

    void setupTimeoutTask();

    void cancelTimeoutTask();

}
