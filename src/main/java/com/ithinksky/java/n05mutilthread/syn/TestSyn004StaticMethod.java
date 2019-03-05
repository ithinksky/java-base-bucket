package com.ithinksky.java.n05mutilthread.syn;


/**
 * public synchronized static void method() {
 *    // todo
 * }
 *
 * 我们知道静态方法是属于类的而不属于对象的。同样的，
 * synchronized修饰的静态方法锁定的是这个类的所有对象
 * myThread1 和 myThread2 是 MyThread 的两个对象，
 * 但在thread1和thread2并发执行时却保持了线程同步。
 * 这是因为run中调用了静态方法method，而静态方法是属于类的，
 * 所以 myThread1 和 myThread2 相当于用了同一把锁
 *
 * @author tengpeng.gao
 * @since 2019-02-26
 */
public class TestSyn004StaticMethod {

    static class MyThread implements Runnable {

        private static int count;

        public MyThread() {
            count = 0;
        }

        public static synchronized void method() {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + " == " + count++);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
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
