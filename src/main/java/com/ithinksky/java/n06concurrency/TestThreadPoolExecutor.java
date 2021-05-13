package com.ithinksky.java.n06concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author tengpeng.gao
 */
public class TestThreadPoolExecutor {

    public static void main(String[] args) {

        // 定义的五种线程池的定义及实现原理，应用场景
        Executors.newCachedThreadPool();
        Executors.newFixedThreadPool(1);
        Executors.newScheduledThreadPool(10);
        Executors.newSingleThreadExecutor();
        Executors.newWorkStealingPool(10);

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,
                3,
                10,
                TimeUnit.HOURS,
                null,
                null,
                null);

    }


}
