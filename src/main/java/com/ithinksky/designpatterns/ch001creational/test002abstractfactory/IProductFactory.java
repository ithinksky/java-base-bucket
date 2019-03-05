package com.ithinksky.designpatterns.ch001creational.test002abstractfactory;

/**
 * 计算机外设生产工厂
 *
 * @author tengpeng.gao
 * @since 2019-02-16
 */
public interface IProductFactory {

    /**
     * 生产鼠标
     *
     * @return
     */
    IProductMouse createProductMouse();

    /**
     * 生产键盘
     *
     * @return
     */
    IProductKeyBoard createProductKeyBoard();

}
