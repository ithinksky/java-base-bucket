package com.ithinksky.designpatterns.ch002structural.test002bridge.t001;

/**
 * 桥接模式
 *
 * @author tengpeng.gao
 * @since 2019-02-16
 */
public class TestBridge001 {

    public static void main(String[] args) {
        Abstraction abstraction = new RefinedAbstraction();

        //调用第一个实现类
        abstraction.setImplementor(new ConcreateImplementorA());
        abstraction.operation();

        //调用第二个实现类
        abstraction.setImplementor(new ConcreateImplementorB());
        abstraction.operation();

    }

}
