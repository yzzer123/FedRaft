package org.bupt.fedraft.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author yzzer
 */
public class WriteReadObject<T> {
    private static final Logger logger = LoggerFactory.getLogger(WriteReadObject.class);

    final private T obj;

    final private ReadWriteLock rwlock = new ReentrantReadWriteLock(true);


    public WriteReadObject(T obj) {
        this.obj = obj;
    }


    public void visit(ReadWriteObjWatcher<T> watcher, VisitType type) {
        Lock lock = (type == VisitType.READ ? rwlock.readLock() : rwlock.writeLock());
        lock.lock();
        try {
            watcher.work(obj);
        } catch (Exception e) {
            logger.error("error happened in modify WriteReadObject:" + e.getMessage());
        } finally {
            lock.unlock();
        }
    }

}
