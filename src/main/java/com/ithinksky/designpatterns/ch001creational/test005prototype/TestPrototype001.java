package com.ithinksky.designpatterns.ch001creational.test005prototype;

/**
 * 原型模式
 *
 * @author tengpeng.gao
 * @since 2019-02-16
 */
public class TestPrototype001 {

    public static void main(String[] args) {

        HeroFactory heroFactory;
        Warlord warlord;

        heroFactory = new HeroFactoryImpl(new OrcWarlord());
        warlord = heroFactory.createWarlord();
        System.out.println("warlord: === " + warlord.toString());

        heroFactory = new HeroFactoryImpl(new ElfWarlord());
        warlord = heroFactory.createWarlord();
        System.out.println("warlord: === " + warlord.toString());
    }


}
