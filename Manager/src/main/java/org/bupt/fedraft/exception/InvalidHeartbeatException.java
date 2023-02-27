package org.bupt.fedraft.exception;

import java.io.IOException;
import java.io.Serializable;

public class InvalidHeartbeatException extends IOException implements Serializable {

    public InvalidHeartbeatException(String msg) {
        super(msg);
    }

    public InvalidHeartbeatException(String msg, Throwable t) {
        super(msg, t);
    }

}
