package com.ithinksky.designpatterns.ch002structural.test005facade.t001;

/**
 * @author tengpeng.gao
 * @since 2019-02-20
 */
public class Memory implements Component {
    @Override
    public void start() {
        System.out.println("memory start...");
    }

    @Override
    public void shutDown() {
        System.out.println("memory shutdown...");
    }
}
