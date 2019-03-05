package com.ithinksky.designpatterns.ch002structural.test004decorator.t001;

/**
 * 装饰模式
 *
 * @author tengpeng.gao
 * @since 2019-02-20
 */
public class TestDecorator001 {

    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        ConcreteDecorateA decorateA = new ConcreteDecorateA();
        ConcreteDecorateB decorateB = new ConcreteDecorateB();

        //将ConcreateComponent类包装成ConcreteDecorateA
        decorateA.decorate(component);
        //将ConcreteDecorateA类包装成ConcreteDecorateB
        decorateB.decorate(decorateA);
//
        decorateB.operation();
    }

}
