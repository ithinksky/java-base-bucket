package com.ithinksky.java.n05mutilthread.base.producerconsumer.t001;

/**
 * 消费者
 *
 * @author tengpeng.gao
 * @since 2019-02-27
 */
public class Consumer implements Runnable {

    private ProductRepository productRepository;

    public Consumer(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run() {
        productRepository.consume();
    }
}
