package com.ithinksky.designpatterns.ch001creational.test005prototype;

/**
 * 军队，具体原型类，实现一个Clone自身的操作。
 *
 * @author tengpeng.gao
 * @since 2019-02-16
 */
public interface Warlord extends Prototype {
    @Override
    Warlord clone() throws CloneNotSupportedException;
}
