package org.bupt.cad.fedraft.utils;

public interface TimeoutKeeper {

    void resetTimeoutTask();

    void setupTimeoutTask();

    void cancelTimeoutTask();

}
