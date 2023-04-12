package org.bupt.fedraft.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author yzzer
 */
public class WriteReadLockObject<T> {
    private static final Logger logger = LoggerFactory.getLogger(WriteReadLockObject.class);

    final private T obj;

    final private ReadWriteLock rwlock = new ReentrantReadWriteLock(true);


    public WriteReadLockObject(T obj) {
        this.obj = obj;
    }


    public void visit(ReadWriteLockVisitor<T> watcher, VisitType type) {
        Lock lock = (type == VisitType.READ ? rwlock.readLock() : rwlock.writeLock());
        lock.lock();
        try {
            watcher.work(obj);
        } catch (Exception e) {
            logger.error("error happened in modify WriteReadLockObject:" + e.getMessage());
        } finally {
            lock.unlock();
        }
    }

}
