package com.ithinksky.java.n05mutilthread.base;

/**
 * join()
 *
 * join方法是Thread类中的一个方法，该方法的定义是等待该线程终止。
 * 其实就是join()方法将挂起调用线程的执行，直到被调用的对象完成它的执行
 *
 * 有T1、T2、T3三个线程，你怎样保证T2在T1执行完后执行，T3在T2执行完后执行
 *
 * @author tengpeng.gao
 * @since 2019-02-27
 */
public class TestBase001Join {

    static class MyThread implements Runnable {

        private Thread myThread;

        public void setMyThread(Thread myThread) {
            this.myThread = myThread;
        }

        @Override
        public void run() {

            try {
                if (myThread != null) {
                    myThread.join();
                }
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " == " + i);
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        MyThread myThread1 = new MyThread();
        Thread t1 = new Thread(myThread1, "t1");

        MyThread myThread2 = new MyThread();
        // 线程2等待线程1执行完成
        myThread2.setMyThread(t1);
        Thread t2 = new Thread(myThread2, "t2");

        MyThread myThread3 = new MyThread();

        // 线程3等待线程2执行完成
        myThread3.setMyThread(t2);
        Thread t3 = new Thread(myThread3, "t3");

        t1.start();
        t2.start();
        t3.start();

//        Thread.sleep(2000);

    }

}



