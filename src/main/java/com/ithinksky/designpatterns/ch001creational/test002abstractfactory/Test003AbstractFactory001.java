package com.ithinksky.designpatterns.ch001creational.test002abstractfactory;

/**
 * 抽象工厂模式
 *
 * @author tengpeng.gao
 * @since 2019-02-15
 */
public class Test003AbstractFactory001 {

    public static void main(String[] args) {

        IProductFactory IProductFactoryLenovo = new ProductFactoryLenovo();
        new Client(IProductFactoryLenovo);

        System.out.println("========================= ");

        IProductFactory IProductFactoryLogitech = new ProductFactoryLogitech();
        new Client(IProductFactoryLogitech);

    }

}
