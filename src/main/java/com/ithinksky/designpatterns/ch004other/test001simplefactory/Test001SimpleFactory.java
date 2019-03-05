package com.ithinksky.designpatterns.ch004other.test001simplefactory;

/**
 * 简单工厂模式  （静态工厂模式）
 *
 * @author tengpeng.gao
 * @since 2019-02-15
 */
public class Test001SimpleFactory {

    public static void main(String[] args) {
        System.out.println(Factory.createProduct("B"));
    }

}
