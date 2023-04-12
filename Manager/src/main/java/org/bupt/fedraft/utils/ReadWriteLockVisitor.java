package org.bupt.fedraft.utils;

/**
 * Manager的状态处理器
 *
 * @param <T> 要处理的数据类型
 * @author yzzer
 */
public interface ReadWriteLockVisitor<T> {
    /**
     * 对线程安全参数的访问接口
     *
     * @param t 需要访问的线程安全参数
     */
    void work(T t);
}