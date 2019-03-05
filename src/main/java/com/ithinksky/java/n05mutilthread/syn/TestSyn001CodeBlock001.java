package com.ithinksky.java.n05mutilthread.syn;

/**
 * 1. 修饰一个代码块，被修饰的代码块称为同步语句块，其作用的范围是大括号{}括起来的代码，作用的对象是调用这个代码块的对象；
 *
 * @author tengpeng.gao
 * @since 2019-02-26
 */
public class TestSyn001CodeBlock001 {

    static class MyThread implements Runnable {

        private static int count;

        public int getCount() {
            return count;
        }

        public MyThread() {
            count = 0;
        }

        @Override
        public void run() {
            synchronized (this) {
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
    }


    public static void main(String[] args) {
        demoA();
//        demoB();
    }

    /**
     * 锁的是同一个实例对象，可以实现同步
     * 一个线程访问一个对象中的synchronized(this)同步代码块时，其他试图访问该对象的线程将被阻塞。
     * 当两个并发线程(thread1和thread2)访问同一个对象(syncThread)中的synchronized代码块时，
     * 在同一时刻只能有一个线程得到执行，另一个线程受阻塞，
     * 必须等待当前线程执行完这个代码块以后才能执行该代码块。
     * Thread1和thread2是互斥的，因为在执行synchronized代码块时会锁定当前的对象，
     * 只有执行完该代码块才能释放该对象锁，下一个线程才能执行并锁定该对象。
     */
    public static void demoA() {
        MyThread myThread = new MyThread();
        Thread thread1 = new Thread(myThread,"thread1");
        Thread thread2 = new Thread(myThread, "thread2");
        thread1.start();
        thread2.start();
    }

    /**
     * 两把锁锁两个实例对象，不能实现同步
     * 因为synchronized只锁定对象，每个对象只有一个锁（lock）与之相关联
     * 线程thread1执行的是myThread1对象中的synchronized代码(run)，
     * 而线程thread2执行的是myThread2对象中的synchronized代码(run)；
     * 我们知道synchronized锁定的是对象，
     * 这时会有两把锁分别锁定syncThread1对象和syncThread2对象，
     * 而这两把锁是互不干扰的，不形成互斥，所以两个线程可以同时执行。
     */
    public static void demoB() {
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        Thread thread1 = new Thread(myThread1, "thread1");
        Thread thread2 = new Thread(myThread2, "thread2");
        thread1.start();
        thread2.start();
    }

}
