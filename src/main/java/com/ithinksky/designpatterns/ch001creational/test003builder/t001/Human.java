package com.ithinksky.designpatterns.ch001creational.test003builder.t001;

/**
 * 一个复杂的产品
 *
 * @author tengpeng.gao
 * @since 2019-02-16
 */
public class Human {

    private String head;
    private String body;
    private String foot;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getFoot() {
        return foot;
    }

    public void setFoot(String foot) {
        this.foot = foot;
    }

}
