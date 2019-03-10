package com.ithinksky.java.n06concurrency.tools.countdownlatch.t003;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * CountDownLatch 应用三
 * 应用于多个线程之间，等待所有线程就绪，同时执行
 *
 * @author tengpeng.gao
 * @since 2019/3/10
 */
public class CountDownLatchDemo003 {

    public static void main(String[] args) throws InterruptedException {
        int threadCount = 10;
        CountDownLatch doneSignal = new CountDownLatch(threadCount);

        Executor executor = Executors.newFixedThreadPool(threadCount);

        for (int i = 1; i <= threadCount; i++) {
            executor.execute(new Worker(doneSignal, i));
        }

        // wait for all to finish
        doneSignal.await();

    }


    static class Worker implements Runnable {

        private final CountDownLatch doneSignal;

        private final int i;

        public Worker(CountDownLatch doneSignal, int i) {
            this.doneSignal = doneSignal;
            this.i = i;
        }

        @Override
        public void run() {
            this.doWork(i);
            doneSignal.countDown();
        }

        private void doWork(int i) {
            System.out.println(Thread.currentThread().getName() + " == doWork = " + i);
        }
    }

}
