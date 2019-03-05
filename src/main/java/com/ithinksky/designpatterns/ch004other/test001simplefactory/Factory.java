package com.ithinksky.designpatterns.ch004other.test001simplefactory;

/**
 * @author tengpeng.gao
 * @since 2019-02-16
 */
public class Factory {

    public static String createProduct(String name) {
        Product product = null;
        if ("A".equals(name)) {
            product = new ProductA();
        } else if ("B".equals(name)) {
            product = new ProductB();
        }
        return product.createProduct();
    }

}
