package org.bupt.fedraft.exception;

import java.io.Serializable;

/**
 * 节点的状态转换非法
 */
public class StateChangeException extends RuntimeException implements Serializable {
    public StateChangeException(String msg) {
        super(msg);
    }

    public StateChangeException(String msg, Throwable t) {
        super(msg, t);
    }

}
