package com.ithinksky.designpatterns.ch001creational.test005prototype;

/**
 * 兽人军
 *
 * @author tengpeng.gao
 * @since 2019-02-16
 */
public class OrcWarlord implements Warlord {

    public OrcWarlord() {
    }

    @Override
    public Warlord clone() throws CloneNotSupportedException {
        return new OrcWarlord();
    }

    @Override
    public String toString() {
        return "Orcish warlord";
    }
}
