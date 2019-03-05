package com.ithinksky.designpatterns.ch001creational.test001factorymethod;

/**
 * @author tengpeng.gao
 * @since 2019-02-16
 */
public class FactoryA implements Factory {

    @Override
    public Product createProduct() {
        return new ProductA();
    }
}
