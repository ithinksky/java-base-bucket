package com.ithinksky.designpatterns.ch002structural.test007proxy.t002;

/**
 * 真实主题
 *
 * @author tengpeng.gao
 * @since 2019-02-21
 */
public class SubjectImpl implements Subject {

    @Override
    public void sayHi() {
        System.out.println("hi");
    }

    @Override
    public void sayHello() {
        System.out.println("Hello");
    }
}
