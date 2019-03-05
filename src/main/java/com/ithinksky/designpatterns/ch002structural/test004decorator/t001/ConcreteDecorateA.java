package com.ithinksky.designpatterns.ch002structural.test004decorator.t001;

/**
 * @author tengpeng.gao
 * @since 2019-02-20
 */
public class ConcreteDecorateA extends Decorate {
    @Override
    protected void operation() {
        //添加附加操作
        System.out.println("do something in ConcreteDecorateA...");
        //调用被包装类的方法
        component.operation();
    }
}
