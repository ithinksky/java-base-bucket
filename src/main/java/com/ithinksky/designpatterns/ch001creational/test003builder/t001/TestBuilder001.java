package com.ithinksky.designpatterns.ch001creational.test003builder.t001;

/**
 * 建造者模式
 *
 * @author tengpeng.gao
 * @since 2019-02-16
 */
public class TestBuilder001 {

    public static void main(String[] args) {
        Director director = new Director();

        Human smartMan = director.createHumanByDirector(new SmartManBuilder());
        System.out.println(smartMan.getHead());
        System.out.println(smartMan.getBody());
        System.out.println(smartMan.getFoot());

        System.out.println("======================================================");

        Human foolishMan = director.createHumanByDirector(new FoolishManBuilder());
        System.out.println(foolishMan.getHead());
        System.out.println(foolishMan.getBody());
        System.out.println(foolishMan.getFoot());

    }

}
