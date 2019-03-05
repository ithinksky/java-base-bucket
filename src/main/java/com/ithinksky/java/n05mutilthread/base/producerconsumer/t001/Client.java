package com.ithinksky.java.n05mutilthread.base.producerconsumer.t001;

/**
 * 使用 synchronized wait notifyAll
 *
 * 实现生产者消费者问题
 *
 * @author tengpeng.gao
 * @since 2019-02-27
 */
public class Client {

    public static void main(String[] args) {
        ProductRepository productRepository = new ProductRepository();

        for (int i = 0; i < 15; i++) {
            new Thread(new Producer(productRepository), "Producer：" + i).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(new Consumer(productRepository), "Consumer：" + i).start();
        }

    }

}
