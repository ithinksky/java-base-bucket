package com.ithinksky.java.n06concurrency.ch001lock.t002;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReentrantReadWriteLock 读写锁降级的应用
 *
 * 锁降级中读锁的获取是否有必要？
 * 有必要，主要是为了保证数据的可见性，如果当前线程不获取读锁而直接释放写锁，
 * 假设此刻另一个线程（T）获取了写锁并修改了数据，那么当前线程是无法感知线程T的数据更新。
 * 如果当前线程获取读锁，即遵循锁降级的步骤，则线程T
 * 将会被阻塞，知道当前线程使用数据并释放读锁之后，线程T才能获取写锁进行数据更新。
 *
 * @author tengpeng.gao
 * @since 2019/3/5
 */
public class Lock003DowngradeCacheData {


    public static void main(String[] args) {
        Lock003DowngradeCacheData cachedData = Lock003DowngradeCacheData.getInstance();
        cachedData.processCachedData("a");
        cachedData.processCachedData("b");
        cachedData.processCachedData("c");
        cachedData.processCachedData("d");
        cachedData.processCachedData("e");

        cachedData.showCache();

        cachedData.clear();

        cachedData.showCache();

    }


    /**
     * 缓存都应该是单例的，在这里用单例模式设计
     */
    public static final Lock003DowngradeCacheData cachedData = Lock003DowngradeCacheData.getInstance();

    /**
     * 缓存
     */
    private Map<String, Object> cache = new HashMap<>();

    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private Lock readLock = rwl.readLock();
    private Lock writeLock = rwl.writeLock();
    private volatile boolean cacheValid;
    private Object data;

    private Lock003DowngradeCacheData() {
    }

    public static Lock003DowngradeCacheData getInstance() {
        return new Lock003DowngradeCacheData();
    }

    /**
     * 读取指定 key 的缓存数据，
     * <p>如果对应缓存不存在，则读取数据，更新缓存
     *
     * @param key
     * @return key 对应的缓存数据
     */
    public Object processCachedData(String key) {
        readLock.lock();
        data = cache.get(key);
        if (data == null) {
            cacheValid = false;
        }
        if (!cacheValid) {

            // Must release read lock before acquiring write lock
            readLock.unlock();
            writeLock.lock();

            try {
                // Recheck state because another thread might have
                // acquired write lock and changed state before we did.
                if (!cacheValid) {
                    Random r = new Random();
                    data = r.nextInt(10); // 获取数据（数据库、文件、其他存储等等）
                    cache.put(key, data); // 放入缓存
                    cacheValid = true;
                }

                // Downgrade by acquiring read lock before releasing write lock
                readLock.lock();
            } finally {
                writeLock.unlock(); // Unlock write, still hold read
            }
        }

        try {
            return data;
        } finally {
            readLock.unlock();
        }
    }

    /**
     * 查看缓存内容
     */
    public void showCache() {
        readLock.lock();
        try {
            System.out.println("查看缓存内容……");
            cache.forEach((s, o) -> System.out.println("key === " + s + " value === " + o));
        } finally {
            readLock.unlock();
        }
    }

    /**
     * 清空缓存
     */
    public void clear() {
        writeLock.lock();
        try {
            System.out.println("清空缓存……");
            cache.clear();
        } finally {
            writeLock.unlock();
        }
    }

}
