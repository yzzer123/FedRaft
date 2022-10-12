package org.bupt.cad.fedraft.exception;

/**
 * 节点的状态转换非法
 */
public class StateChangeException extends RuntimeException {
    public StateChangeException(String msg) {
        super(msg);
    }

    public StateChangeException(String msg, Throwable t) {
        super(msg, t);
    }

}
