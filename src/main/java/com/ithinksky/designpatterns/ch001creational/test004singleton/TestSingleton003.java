package com.ithinksky.designpatterns.ch001creational.test004singleton;

/**
 * 线程安全的“懒汉模式”
 * 在多线程情形下，保证了“懒汉模式”的线程安全
 * 众所周知在多线程情形下，synchronized方法通常效率低，显然这不是最佳的实现方案。
 *
 * @author tengpeng.gao
 * @since 2019-02-16
 */
public final class TestSingleton003 {

    private static TestSingleton003 INSTANCE = null;

    private TestSingleton003() {
    }

    public static synchronized TestSingleton003 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TestSingleton003();
        }
        return INSTANCE;
    }

}

