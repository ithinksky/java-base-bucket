package com.ithinksky.designpatterns.ch001creational.test003builder.t001;

/**
 * 产品的标准
 *
 * @author tengpeng.gao
 * @since 2019-02-16
 */
public interface IBuildHuman {

    void buildHead();

    void buildBody();

    void buildFoot();

    Human createHuman();

}
