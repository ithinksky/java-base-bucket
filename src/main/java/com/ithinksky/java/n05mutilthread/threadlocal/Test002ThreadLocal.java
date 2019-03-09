package com.ithinksky.java.n05mutilthread.threadlocal;

import java.util.concurrent.TimeUnit;

/**
 * ThreadLocal 应用案例二
 *
 * 可以复用在方法耗时的统计功能上，
 * 结合 AOP 编程中，可以更好地应用
 *
 * @author tengpeng.gao
 * @since 2019/3/9
 */
public class Test002ThreadLocal {

    static class Profiler {

        private static final ThreadLocal<Long> THREAD_LOCAL = ThreadLocal.withInitial(() -> System.currentTimeMillis());

        public static final void begin() {
            THREAD_LOCAL.set(System.currentTimeMillis());
        }

        public static final long end() {
            return System.currentTimeMillis() - THREAD_LOCAL.get();
        }

    }


    public static void main(String[] args) throws InterruptedException {
        Profiler.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Cost: " + Profiler.end() + " mills");
    }

}
