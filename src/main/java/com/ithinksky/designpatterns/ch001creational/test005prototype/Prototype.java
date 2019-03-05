package com.ithinksky.designpatterns.ch001creational.test005prototype;

/**
 * 原型类，声明一个Clone自身的接口；
 *
 * @author tengpeng.gao
 * @since 2019-02-16
 */
public interface Prototype {

    Object clone() throws CloneNotSupportedException;

}
