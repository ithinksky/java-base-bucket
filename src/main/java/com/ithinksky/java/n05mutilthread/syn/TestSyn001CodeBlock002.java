package com.ithinksky.java.n05mutilthread.syn;

/**
 *
 * countAdd是一个synchronized的，
 * printCount是非synchronized的。
 * 从上面的结果中可以看出一个线程访问一个对象的synchronized代码块时，
 * 别的线程可以访问该对象的非synchronized代码块而不受阻塞
 *
 * @author tengpeng.gao
 * @since 2019-02-26
 */
public class TestSyn001CodeBlock002 {

    static class MyThread implements Runnable {

        private static int count;

        public MyThread() {
            count = 0;
        }

        public void countAdd() {
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


        //非synchronized代码块，未对count进行读写操作，所以可以不用synchronized
        public void printCount() {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + " count:" + count);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            if (threadName.equals("A")) {
                countAdd();
            } else if (threadName.equals("B")) {
                printCount();
            }
        }
    }


    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread threadA = new Thread(myThread, "A");
        Thread threadB = new Thread(myThread, "B");
        threadA.start();
        threadB.start();
    }


}
