package com.ithinksky.java.n05mutilthread.define;

/**
 * 实现 Runnable 接口
 *
 * @author tengpeng.gao
 * @since 2019-02-25
 */
public class Thread002ImplRunnable {

    public static void main(String[] args) {

        MyRunnableThread myRunnableThread = new MyRunnableThread();
        new Thread(myRunnableThread).start();
    }

}


class MyRunnableThread implements Runnable {

    @Override
    public void run() {
        System.out.println("MyRunnableThread implements Runnable run() ");
    }

}
