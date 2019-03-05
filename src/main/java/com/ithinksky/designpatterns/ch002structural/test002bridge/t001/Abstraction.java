package com.ithinksky.designpatterns.ch002structural.test002bridge.t001;

/**
 * @author tengpeng.gao
 * @since 2019-02-20
 */
public abstract class Abstraction {

    private Implementor implementor;

    public void setImplementor(Implementor implementor) {
        this.implementor = implementor;
    }

    public Implementor getImplementor() {
        return implementor;
    }

    protected void operation() {
        System.out.println("Abstraction ==== operation");
        implementor.operation();
    }

}
