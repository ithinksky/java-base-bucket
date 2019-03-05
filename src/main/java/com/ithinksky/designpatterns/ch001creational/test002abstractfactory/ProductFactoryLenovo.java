package com.ithinksky.designpatterns.ch001creational.test002abstractfactory;

/**
 * 联想计算机外设生产工厂
 *
 * @author tengpeng.gao
 * @since 2019-02-16
 */
public class ProductFactoryLenovo implements IProductFactory {


    @Override
    public IProductMouse createProductMouse() {
        return new ProductMouseLenovo();
    }

    @Override
    public IProductKeyBoard createProductKeyBoard() {
        return new ProductKeyboardLenovo();
    }
}
