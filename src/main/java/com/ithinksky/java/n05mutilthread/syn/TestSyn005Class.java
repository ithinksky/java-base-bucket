package com.ithinksky.java.n05mutilthread.syn;


/**
 * class ClassName {
 *    public void method() {
 *       synchronized(ClassName.class) {
 *          // todo
 *       }
 *    }
 * }
 *
 * synchronized作用于一个类T时，是给这个类T加锁，T的所有对象用的是同一把锁。
 * 效果同 修饰一个静态方法
 *
 * @author tengpeng.gao
 * @since 2019-02-26
 */
public class TestSyn005Class {

    static class MyThread implements Runnable {

        private static int count;

        public MyThread() {
            count = 0;
        }

        public static void method() {
            synchronized (MyThread.class) {
                for (int i = 0; i < 5; i++) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " == " + count++);
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        @Override
        public void run() {
            method();
        }
    }


    public static void main(String[] args) {
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        Thread thread1 = new Thread(myThread1, "thread1");
        Thread thread2 = new Thread(myThread2, "thread2");
        thread1.start();
        thread2.start();
    }


}
