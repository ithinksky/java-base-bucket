package com.ithinksky.java.n06concurrency.ch001lock.t001;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁应用
 *
 * @author tengpeng.gao
 * @since 2019/3/5
 */
public class RWDictionary {

    private final Map<String, Object> map = new TreeMap<>();
    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private final Lock readLock = rwl.readLock();
    private final Lock writeLock = rwl.writeLock();

    public Object get(String key) {
        readLock.lock();
        try {
            return map.get(key);
        } finally {
            readLock.unlock();
        }
    }

    public String[] getAllKeys() {
        readLock.lock();
        try {
            return (String[]) map.entrySet().toArray();
        } finally {
            readLock.unlock();
        }
    }

    public Object put(String key, Object value) {
        writeLock.lock();
        try {
            return map.put(key, value);
        } finally {
            writeLock.unlock();
        }
    }

    public void clear() {
        writeLock.lock();
        try {
            map.clear();
        } finally {
            writeLock.unlock();
        }
    }


}
