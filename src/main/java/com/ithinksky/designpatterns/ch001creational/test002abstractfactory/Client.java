package com.ithinksky.designpatterns.ch001creational.test002abstractfactory;

/**
 * @author tengpeng.gao
 * @since 2019-02-16
 */
public class Client {

    private IProductMouse productMouse;
    private IProductKeyBoard productKeyBoard;

    public Client(IProductFactory IProductFactory) {
        this.productMouse = IProductFactory.createProductMouse();
        this.productKeyBoard = IProductFactory.createProductKeyBoard();
    }
}
