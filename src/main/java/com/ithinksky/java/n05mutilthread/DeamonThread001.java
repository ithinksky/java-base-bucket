package com.ithinksky.java.n05mutilthread;

/**
 * 守护线程
 *
 * 如果所有的非守护线程都已经执行完毕，那么守护线程将立即被结束，
 * 因此守护线程的finally子句不一定能够执行
 * 当main线程退出时，JVM就会立即关闭所有的后台线程
 *
 * @author tengpeng.gao
 * @since 2019-02-25
 */
public class DeamonThread001 {

    static class MyThread extends Thread {

        @Override
        public void run() {
            try {
                while (!isInterrupted()) {
                    System.out.println(Thread.currentThread().getName() + " run() ");
                }
            } finally {
                System.out.println(" ...finally ");
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new DeamonThread001.MyThread();
//      守护线程中的 finally 不一定会被执行
//        thread.setDaemon(true);
        thread.start();
        Thread.sleep(2);
        thread.interrupt();
    }


}
