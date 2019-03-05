package com.ithinksky.designpatterns.ch001creational.test005prototype;

/**
 * 军工厂具体工厂
 *
 * @author tengpeng.gao
 * @since 2019-02-16
 */
public class HeroFactoryImpl implements HeroFactory {

    private Warlord warlord;

    public HeroFactoryImpl(Warlord warlord) {
        this.warlord = warlord;
    }

    @Override
    public Warlord createWarlord() {
        try {
            return warlord.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
