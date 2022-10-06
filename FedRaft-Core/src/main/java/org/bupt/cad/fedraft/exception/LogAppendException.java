package org.bupt.cad.fedraft.exception;

public class LogAppendException extends Exception{
    public LogAppendException(String msg) {
        super(msg);
    }

    public LogAppendException(String msg, Throwable t) {
        super(msg, t);
    }
}
