package com.ithinksky.designpatterns.ch002structural.test005facade.t001;

/**
 * 外观模式
 *
 * @author tengpeng.gao
 * @since 2019-02-20
 */
public class TestFacade001 {

    public static void main(String[] args) {
        Computer computer = new Computer();

        System.out.println("computer begin to start...");
        computer.start();
        System.out.println("computer started.");

        System.out.println("computer begin to shutdown...");
        computer.shutDown();
        System.out.println("computer shutdown.");
    }

}
