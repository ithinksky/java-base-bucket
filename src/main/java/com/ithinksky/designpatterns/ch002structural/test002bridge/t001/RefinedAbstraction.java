package com.ithinksky.designpatterns.ch002structural.test002bridge.t001;

/**
 * @author tengpeng.gao
 * @since 2019-02-20
 */
public class RefinedAbstraction extends Abstraction {

    @Override
    protected void operation() {
        System.out.println("RefinedAbstraction ==== operation");
        super.getImplementor().operation();
    }

}
