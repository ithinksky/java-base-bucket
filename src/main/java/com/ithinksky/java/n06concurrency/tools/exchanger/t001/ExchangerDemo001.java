package com.ithinksky.java.n06concurrency.tools.exchanger.t001;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Exchanger （交换者的应用）
 *
 * @author tengpeng.gao
 * @since 2019/3/11
 */
public class ExchangerDemo001 {

    private static final Exchanger<String> e = new Exchanger();

    private static final ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {

        threadPool.execute(() -> {
            try {
                String a = "银行流水A";
                e.exchange(a);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        });

        threadPool.execute(() -> {
            try {
                String b = "银行流水B";
                String a = e.exchange("b");
                System.out.println("a 和 b 的数据是否一致： " + a.equals(b) + ",a录入的是：" + a + ",b录入的是：" + b);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        });

        threadPool.shutdown();
    }


}
