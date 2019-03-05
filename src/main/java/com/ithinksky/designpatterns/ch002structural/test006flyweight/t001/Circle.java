package com.ithinksky.designpatterns.ch002structural.test006flyweight.t001;

/**
 * @author tengpeng.gao
 * @since 2019-02-20
 */
public class Circle extends Shape {
    private String color;

    public Circle(String color) {
        this.color = color;
    }

    public void draw() {
        System.out.println("画了一个" + color + "的圆形");
    }

}
