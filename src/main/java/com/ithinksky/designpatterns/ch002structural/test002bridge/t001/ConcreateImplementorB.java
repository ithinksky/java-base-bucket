package com.ithinksky.designpatterns.ch002structural.test002bridge.t001;

/**
 * @author tengpeng.gao
 * @since 2019-02-20
 */
public class ConcreateImplementorB implements Implementor {
    @Override
    public void operation() {
        System.out.println("this is concreteImplementorB's operation...");
    }
}
