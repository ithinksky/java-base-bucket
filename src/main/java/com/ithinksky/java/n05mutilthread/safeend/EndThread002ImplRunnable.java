package com.ithinksky.java.n05mutilthread.safeend;

/**
 * 中断 实现 Runnable 接口
 *
 * @author tengpeng.gao
 * @since 2019-02-25
 */
public class EndThread002ImplRunnable {

    public static void main(String[] args) throws InterruptedException {

        MyRunnableThread myRunnableThread = new MyRunnableThread();
        Thread thread = new Thread(myRunnableThread);
        thread.start();
        Thread.sleep(2);
        thread.interrupt();
    }

}


class MyRunnableThread implements Runnable {

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println(Thread.currentThread().getName() + " run() ");
        }
        System.out.println(Thread.currentThread().getName() + " flag is " + Thread.currentThread().isInterrupted());
    }

}
