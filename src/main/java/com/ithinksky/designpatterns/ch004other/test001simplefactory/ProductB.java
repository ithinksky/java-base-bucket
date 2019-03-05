package com.ithinksky.designpatterns.ch004other.test001simplefactory;

/**
 * @author tengpeng.gao
 * @since 2019-02-16
 */
public class ProductB implements Product {

    @Override
    public String createProduct() {
        return "ProductB createProduct";
    }
}
