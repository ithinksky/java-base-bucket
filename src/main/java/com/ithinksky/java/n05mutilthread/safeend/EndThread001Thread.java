package com.ithinksky.java.n05mutilthread.safeend;

/**
 * 中断 继承 Thread 类
 *
 * @author tengpeng.gao
 * @since 2019-02-25
 */
public class EndThread001Thread {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new MyThread();
        thread.start();
        Thread.sleep(2);
        thread.interrupt();

    }

}


class MyThread extends Thread {

    @Override
    public void run() {
        while (!isInterrupted()) {
            System.out.println(Thread.currentThread().getName() + " run() ");
        }
        System.out.println(Thread.currentThread().getName() + " flag is " + isInterrupted());
    }

}
