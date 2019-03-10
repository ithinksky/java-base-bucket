package com.ithinksky.java.n06concurrency.tools.cyclicbarrier.t002;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 可循环屏障
 * 让一个组线程到达一个屏障（也叫同步点）时被阻塞，
 * 直到最后一个线程到达屏障时，屏障才会开门，
 * 所有被屏障拦截的线程才会继续运行。
 *
 * 构造方法 CyclicBarrier(int parties, Runnable barrierAction)
 * 用于在线程到达屏障时，优先执行 barrierAction ，方便处理更复杂的业务场景
 *
 * @author tengpeng.gao
 * @since 2019/3/10
 */
public class CyclicBarrierDemo002 {

    public static void main(String[] args) {

        CyclicBarrier c = new CyclicBarrier(2, new A());
        new Thread(new Worker(c)).start();

        try {
            c.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("2");


    }

    static class Worker implements Runnable {

        private final CyclicBarrier cyclicBarrier;

        public Worker(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("1");
        }
    }

    static class A implements Runnable {
        @Override
        public void run() {
            System.out.println("3");
        }
    }


}
