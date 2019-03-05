package com.ithinksky.java.n05mutilthread;

/**
 * start() 与 run() 区别
 *
 * @author tengpeng.gao
 * @since 2019-02-25
 */
public class StartAndRun001 {

    static class MyThread extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 90; i++) {
                System.out.println(Thread.currentThread().getName() + " ...finally " + i);
            }
        }

    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.run(); // 当做普通方法调用
        myThread.start(); // 将系统资源进行关联

    }

}
