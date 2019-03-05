package com.ithinksky.java.n06concurrency.ch001lock.t002;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 1. 同一个线程中，在没有释放读锁的情况下，就去申请写锁，这属于锁升级，ReentrantReadWriteLock是不支持的。
 *
 * @author tengpeng.gao
 * @since 2019/3/5
 */
public class Lock001Upgrade {

    public static void main(String[] args) {

        ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
        Lock readLock = rwl.readLock();
        Lock writeLock = rwl.writeLock();

        readLock.lock();
        System.out.println("获取 readLock");

        writeLock.lock();
        System.out.println("获取 writeLock 失败，阻塞");

        // 执行结果：
        // 获取 readLock
        // 程序阻塞
    }

}
