package com.ithinksky.java.jvm;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class VmThread {

    private static ExecutorService es = new ThreadPoolExecutor(
            50,
            100,
            0L,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(100000));

    public static void main(String[] args) throws Exception {

        int MAX = 200;
        int MIN = 20;
        for (int i = 0; i < 100000; i++) {
            es.execute(() -> {
//                System.out.print(1);
                try {
                    Random random = new Random();
                    int randNumber = random.nextInt(MAX - MIN + 1) + MIN;
                    Thread.sleep(randNumber);
//                    System.out.println(randNumber + "ms");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        ThreadPoolExecutor tpe = ((ThreadPoolExecutor) es);

        while (true) {
            System.out.println();

            int queueSize = tpe.getQueue().size();
            System.out.println("当前排队线程数：" + queueSize);

            int activeCount = tpe.getActiveCount();
            System.out.println("当前活动线程数：" + activeCount);

            long completedTaskCount = tpe.getCompletedTaskCount();
            System.out.println("执行完成线程数：" + completedTaskCount);

            long taskCount = tpe.getTaskCount();
            System.out.println("总线程数：" + taskCount);

            Thread.sleep(3000);
        }

    }

}
