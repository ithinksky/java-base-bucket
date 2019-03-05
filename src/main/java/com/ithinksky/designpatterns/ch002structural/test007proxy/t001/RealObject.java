package com.ithinksky.designpatterns.ch002structural.test007proxy.t001;

/**
 * @author tengpeng.gao
 * @since 2019-02-20
 */
public class RealObject implements AbstractObject {
    @Override
    public void operation() {
        System.out.println("do operation...");
    }
}
