package com.ithinksky.java.n05mutilthread.define;

/**
 * 继承 Thread 类
 *
 * @author tengpeng.gao
 * @since 2019-02-25
 */
public class Thread001ExtendsThread {

    public static void main(String[] args) {

        Thread thread = new MyThread();
        thread.start();

//        一个线程只能调用一次start()方法，因为调用一次后线程的状态已经发生变化
//        多次调用start()方法会抛出IllegalThreadStateException异常
//        thread.start();

    }

}


class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("MyThread MyThread extends Thread run() ");
    }

}
