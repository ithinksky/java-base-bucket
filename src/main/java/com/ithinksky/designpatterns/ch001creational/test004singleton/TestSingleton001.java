package com.ithinksky.designpatterns.ch001creational.test004singleton;

/**
 * 饿汉式：
 * 实现起来简单，没有多线程同步问题。
 * 空间换时间
 *
 * @author tengpeng.gao
 * @since 2019-02-16
 */
public final class TestSingleton001 {

    private final static TestSingleton001 INSTANCE = new TestSingleton001();

    private TestSingleton001() {
    }

    public static TestSingleton001 getInstance() {
        return INSTANCE;
    }
}
