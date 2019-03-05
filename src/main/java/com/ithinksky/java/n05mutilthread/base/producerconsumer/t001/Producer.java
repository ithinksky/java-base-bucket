package com.ithinksky.java.n05mutilthread.base.producerconsumer.t001;

/**
 * 生产者
 *
 * @author tengpeng.gao
 * @since 2019-02-27
 */
public class Producer implements Runnable {

    private ProductRepository productRepository;

    public Producer(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run() {
        productRepository.produce();
    }
}
