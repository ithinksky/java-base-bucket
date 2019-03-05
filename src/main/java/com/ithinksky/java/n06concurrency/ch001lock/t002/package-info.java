/**
 *
 * 读写锁维护了一对锁，一个读锁和一个写锁。
 * 在同一时刻可以允许多个读线程访问，但是在写线程访问时，所有的读线程和其他写线程均被阻塞。
 *
 * 1. 同一个线程中，在没有释放读锁的情况下，就去申请写锁，这属于锁升级，ReentrantReadWriteLock是不支持的。
 *
 * 2. 同一个线程中，在没有释放写锁的情况下，就去申请读锁，这属于锁降级，ReentrantReadWriteLock是支持的
 *
 * @author tengpeng.gao
 * @since 2019/3/5
 */
package com.ithinksky.java.n06concurrency.ch001lock.t002;