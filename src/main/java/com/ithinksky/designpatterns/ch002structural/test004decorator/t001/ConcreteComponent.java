package com.ithinksky.designpatterns.ch002structural.test004decorator.t001;

/**
 * @author tengpeng.gao
 * @since 2019-02-20
 */
public class ConcreteComponent extends Component {
    @Override
    protected void operation() {
        System.out.println("do something in concreteComponent...");
    }
}
