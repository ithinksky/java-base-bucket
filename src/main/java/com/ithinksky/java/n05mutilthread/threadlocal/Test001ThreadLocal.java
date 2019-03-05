package com.ithinksky.java.n05mutilthread.threadlocal;

/**
 * ThreadLocal
 * ThreadLocal的实例代表了一个线程局部的变量，
 * 每条线程都只能看到自己的值，并不会意识到其它的线程中也存在该变量。
 * 它采用采用空间来换取时间的方式，解决多线程中相同变量的访问冲突问题。
 *
 * 最常见的ThreadLocal使用场景为 用来解决 数据库连接、Session管理等
 *
 * @author tengpeng.gao
 * @since 2019-02-26
 */
public class Test001ThreadLocal {

    static class Bank {

        ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 100);

        public void set() {
            threadLocal.set(threadLocal.get() + 10);
        }

        public Integer get() {
            return threadLocal.get();
        }

    }

    static class Transfer implements Runnable {

        private Bank bank;

        public Transfer(Bank bank) {
            this.bank = bank;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                bank.set();
                System.out.println(Thread.currentThread().getName() + " bank get: === " + bank.get());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        Transfer transfer = new Transfer(bank);
        Thread thread1 = new Thread(transfer);
        Thread thread2 = new Thread(transfer);

        thread1.start();
        thread2.start();

        // t.join()方法阻塞调用此方法的线程(calling thread)，直到线程t完成，
        // 此线程再继续；通常用于在main()主线程内，等待其它线程完成再结束main()主线程
        thread1.join();
        thread2.join();

        System.out.println(" bank get: === " + bank.get());


    }

}
