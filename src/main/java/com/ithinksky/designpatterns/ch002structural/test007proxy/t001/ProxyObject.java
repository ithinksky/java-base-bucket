package com.ithinksky.designpatterns.ch002structural.test007proxy.t001;

/**
 * @author tengpeng.gao
 * @since 2019-02-20
 */
public class ProxyObject implements AbstractObject {
    //对目标类的引用
    private RealObject realObject;

    public ProxyObject(RealObject realObject) {
        this.realObject = realObject;
    }

    @Override
    public void operation() {
        System.out.println("do something before real peration...");
        if (realObject == null) {
            realObject = new RealObject();
        }
        realObject.operation();
        System.out.println("do something after real operation...");
    }
}
