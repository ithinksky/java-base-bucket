package com.ithinksky.designpatterns.ch001creational.test005prototype;

/**
 * 精灵军
 *
 * @author tengpeng.gao
 * @since 2019-02-16
 */
public class ElfWarlord implements Warlord {

    public ElfWarlord() {
    }

    @Override
    public Warlord clone() throws CloneNotSupportedException {
        return new ElfWarlord();
    }

    @Override
    public String toString() {
        return "Elven warlord";
    }
}
