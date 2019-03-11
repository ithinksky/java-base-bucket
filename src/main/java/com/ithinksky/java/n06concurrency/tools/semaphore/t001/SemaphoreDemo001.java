package com.ithinksky.java.n06concurrency.tools.semaphore.t001;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Semaphore (信号量的应用)
 *
 * @author tengpeng.gao
 * @since 2019/3/11
 */
public class SemaphoreDemo001 {

    private static final int THREAD_COUNT = 30;

    // 只允许 10 个并发执行
    private static final Semaphore semaphore = new Semaphore(10);

    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);

    public static void main(String[] args) {

        for (int i = 0; i < THREAD_COUNT; i++) {
            threadPool.execute(() -> {
                try {
                    semaphore.acquire();
                    System.out.println("save data");
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        threadPool.shutdown();
    }


}
