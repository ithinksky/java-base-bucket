package com.ithinksky.designpatterns.ch001creational.test002abstractfactory;

/**
 * 罗技计算机外设生产工厂
 *
 * @author tengpeng.gao
 * @since 2019-02-16
 */
public class ProductFactoryLogitech implements IProductFactory {


    @Override
    public IProductMouse createProductMouse() {
        return new ProductMouseLogitech();
    }

    @Override
    public IProductKeyBoard createProductKeyBoard() {
        return new ProductKeyBoardLogitech();
    }
}
