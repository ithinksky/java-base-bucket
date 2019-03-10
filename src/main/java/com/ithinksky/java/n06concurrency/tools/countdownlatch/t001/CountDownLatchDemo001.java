package com.ithinksky.java.n06concurrency.tools.countdownlatch.t001;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch 应用一
 * 应用于一个线程中的N个步骤
 *
 * @author tengpeng.gao
 * @since 2019/3/10
 */
public class CountDownLatchDemo001 {

    static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            System.out.println("step: 1");
            countDownLatch.countDown();
            System.out.println("step: 2");
            countDownLatch.countDown();
        }).start();
        countDownLatch.await();
        System.out.println("step: 3");
    }

}
