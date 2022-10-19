package org.bupt.cad.fedraft.exception;

import java.io.IOException;

public class InvalidHeartbeatException extends IOException {

    public InvalidHeartbeatException(String msg) {
        super(msg);
    }

    public InvalidHeartbeatException(String msg, Throwable t) {
        super(msg, t);
    }

}
