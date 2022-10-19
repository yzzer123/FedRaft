package org.bupt.cad.fedraft.exception;

import java.io.IOException;

public class LogAppendException extends IOException {
    public LogAppendException(String msg) {
        super(msg);
    }

    public LogAppendException(String msg, Throwable t) {
        super(msg, t);
    }
}
