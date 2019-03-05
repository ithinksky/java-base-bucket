package com.ithinksky.designpatterns.ch002structural.test007proxy.t001;

/**
 * 代理模式
 *
 * @author tengpeng.gao
 * @since 2019-02-20
 */
public class TestProxy001 {

    public static void main(String[] args) {
        AbstractObject proxy = new ProxyObject(new RealObject());
        proxy.operation();
    }

}
