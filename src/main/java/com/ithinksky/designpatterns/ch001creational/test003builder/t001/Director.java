package com.ithinksky.designpatterns.ch001creational.test003builder.t001;

/**
 * 导向器：可以控制组件生成顺序
 *
 * @author tengpeng.gao
 * @since 2019-02-16
 */
public class Director {

    public Human createHumanByDirector(IBuildHuman buildHuman) {
        buildHuman.buildHead();
        buildHuman.buildBody();
        buildHuman.buildFoot();
        return buildHuman.createHuman();
    }

}
