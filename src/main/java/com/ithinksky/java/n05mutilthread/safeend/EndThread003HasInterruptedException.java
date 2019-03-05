package com.ithinksky.java.n05mutilthread.safeend;

import java.util.concurrent.ExecutionException;

/**
 * 中断异常
 *
 * @author tengpeng.gao
 * @since 2019-02-25
 */
public class EndThread003HasInterruptedException {

    static class MyThread extends Thread {

        @Override
        public void run() {
            while (!isInterrupted()) {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    // InterruptedException 异常后，中断标志位会编程 false
                    System.out.println(Thread.currentThread().getName() + " flag is " + isInterrupted());
                    // 需要调用 interrupt() 手动修改中断标志位
                    interrupt();
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " run() ");
            }
            System.out.println(Thread.currentThread().getName() + " flag is " + isInterrupted());
        }

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread thread = new MyThread();
        thread.start();
        Thread.sleep(2);
        thread.interrupt();

    }

}



