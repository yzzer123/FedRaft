package org.bupt.cad.fedraft.exception;

import java.io.IOException;
import java.io.Serializable;

public class LogAppendException extends IOException implements Serializable {
    public LogAppendException(String msg) {
        super(msg);
    }

    public LogAppendException(String msg, Throwable t) {
        super(msg, t);
    }
}
