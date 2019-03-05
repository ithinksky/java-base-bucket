package com.ithinksky.java.n05mutilthread.base.producerconsumer.t001;

import java.util.LinkedList;

/**
 * 仓库
 *
 * @author tengpeng.gao
 * @since 2019-02-27
 */
public class ProductRepository {

    private LinkedList<Product> products = new LinkedList<>();
    private static final int MAX_NUM = 10;

    /**
     * 生产
     */
    public void produce() {
        synchronized (products) {

            // 仓库已经满了
            while (products.size() == MAX_NUM) {
                try {
                    products.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 仓库没满，则生产一个产品
            Product product = new Product("产品", System.currentTimeMillis() + "");
            products.addLast(product);
            System.out.println(Thread.currentThread().getName() + " 生产一个产品 == " + product);
            products.notifyAll();
        }

    }

    /**
     * 消费
     */
    public void consume() {
        synchronized (products) {
            // 仓库里没货了，线程进入等待
            while (products.size() == 0) {
                try {
                    products.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 如果有货，则消费一个产品
            Product product = products.getFirst();
            products.removeFirst();
            System.out.println(Thread.currentThread().getName() + " 消费一个产品 == " + product);
            products.notifyAll();
        }
    }

}
