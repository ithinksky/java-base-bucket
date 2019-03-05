package com.ithinksky.designpatterns.ch001creational.test001factorymethod;

/**
 * 工厂方法模式
 *
 * @author tengpeng.gao
 * @since 2019-02-15
 */
public class Test002FactoryMethod {

    public static void main(String[] args) {
        Factory factoryA = new FactoryA();
        factoryA.createProduct();

        Factory factoryB = new FactoryB();
        factoryB.createProduct();

    }

}
