package com.ithinksky.designpatterns.ch001creational.test004singleton;

/**
 * 懒汉式：非线程安全
 *
 * @author tengpeng.gao
 * @since 2019-02-16
 */
public final class TestSingleton002 {

    private static TestSingleton002 INSTANCE = null;

    private TestSingleton002() {
    }

    public static TestSingleton002 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TestSingleton002();
        }
        return INSTANCE;
    }

}

