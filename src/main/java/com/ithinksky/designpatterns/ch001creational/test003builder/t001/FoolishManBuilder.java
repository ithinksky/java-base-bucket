package com.ithinksky.designpatterns.ch001creational.test003builder.t001;

/**
 * 愚蠢
 *
 * @author tengpeng.gao
 * @since 2019-02-16
 */
public class FoolishManBuilder implements IBuildHuman {

    private Human human;

    public FoolishManBuilder() {
        this.human = new Human();
    }

    @Override
    public void buildHead() {
        human.setHead("愚蠢之脑");
    }

    @Override
    public void buildBody() {
        human.setBody("愚蠢之身");
    }

    @Override
    public void buildFoot() {
        human.setFoot("愚蠢之脚");
    }

    @Override
    public Human createHuman() {
        return human;
    }
}
