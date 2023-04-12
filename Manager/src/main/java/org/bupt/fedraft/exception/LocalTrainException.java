package org.bupt.fedraft.exception;

import java.io.IOException;
import java.io.Serializable;

/**
 * 本地训练发生的异常
 *
 * @author yzzer
 */
public class LocalTrainException extends IOException implements Serializable {

    public LocalTrainException(String msg) {
        super(msg);
    }

    public LocalTrainException(String msg, Throwable t) {
        super(msg, t);
    }

}
