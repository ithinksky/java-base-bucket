package com.ithinksky.designpatterns.ch001creational.test003builder.t001;

/**
 * 智慧
 *
 * @author tengpeng.gao
 * @since 2019-02-16
 */
public class SmartManBuilder implements IBuildHuman {

    private Human human;

    public SmartManBuilder() {
        this.human = new Human();
    }

    @Override
    public void buildHead() {
        human.setHead("智慧大脑");
    }

    @Override
    public void buildBody() {
        human.setBody("智慧之身");
    }

    @Override
    public void buildFoot() {
        human.setFoot("智慧之脚");
    }

    @Override
    public Human createHuman() {
        return human;
    }
}
