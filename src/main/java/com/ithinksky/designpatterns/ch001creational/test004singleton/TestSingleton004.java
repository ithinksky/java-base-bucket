package com.ithinksky.designpatterns.ch001creational.test004singleton;

/**
 * DCL双检查锁机制（DCL：double checked locking）
 *
 * 单例模式的最佳实现方式。内存占用率高，效率高，线程安全，多线程操作原子性。
 *
 * @author tengpeng.gao
 * @since 2019-02-16
 */
public final class TestSingleton004 {

    private static TestSingleton004 INSTANCE = null;

    private TestSingleton004() {
    }

    public static TestSingleton004 getInstance() {
        // 第一次检查instance是否被实例化出来，如果没有进入if块
        if (INSTANCE == null) {
            synchronized (TestSingleton004.class) {
                // 某个线程取得了类锁，实例化对象前第二次检查instance是否已经被实例化出来，如果没有，才最终实例出对象
                if (INSTANCE == null) {
                    INSTANCE = new TestSingleton004();
                }
            }
        }
        return INSTANCE;
    }
}

