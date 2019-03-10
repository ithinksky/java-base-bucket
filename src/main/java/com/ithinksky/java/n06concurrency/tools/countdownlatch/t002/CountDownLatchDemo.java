package com.ithinksky.java.n06concurrency.tools.countdownlatch.t002;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch 应用二
 * 应用于多个线程之间，使用 两个倒计时锁存器 协作多个线程执行
 *
 * @author tengpeng.gao
 * @since 2019/3/10
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        int threadCount = 10;
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(threadCount);
        for (int i = 1; i <= threadCount; i++) {
            new Thread(new Worker(startSignal, doneSignal), "" + i).start();
        }

        // let all threads proceed
        startSignal.countDown();

        // wait for all to finish
        doneSignal.await();

    }


    static class Worker implements Runnable {

        private final CountDownLatch startSignal;

        private final CountDownLatch doneSignal;

        public Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
            this.startSignal = startSignal;
            this.doneSignal = doneSignal;
        }

        @Override
        public void run() {
            try {
                startSignal.await();
                this.doWork();
                doneSignal.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void doWork() {
            System.out.println(Thread.currentThread().getName() + " == doWork");
        }
    }

}
