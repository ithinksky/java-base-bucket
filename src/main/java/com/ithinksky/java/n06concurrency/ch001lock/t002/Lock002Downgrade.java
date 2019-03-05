package com.ithinksky.java.n06concurrency.ch001lock.t002;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 2. 同一个线程中，在没有释放写锁的情况下，就去申请读锁，这属于锁降级，ReentrantReadWriteLock是支持的
 *
 * @author tengpeng.gao
 * @since 2019/3/5
 */
public class Lock002Downgrade {

    public static void main(String[] args) {

        ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
        Lock readLock = rwl.readLock();
        Lock writeLock = rwl.writeLock();

        writeLock.lock();
        System.out.println("获取 writeLock");

        readLock.lock();
        System.out.println("获取 readLock");

        readLock.unlock();
        writeLock.unlock();

        // 执行结果：
        // 获取 writeLock
        // 获取 readLock

    }

}
