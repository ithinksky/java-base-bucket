package com.ithinksky.java.n01base.wrapper;

import org.junit.Test;

/**
 * 追本溯源：查看字节码内容
 * javap -c TestInteger.class
 *
 * 自动装箱：
 *   Integer i = 100; // Integer.valueOf(100)
 *
 * 自动拆箱
 *   integer.intValue()
 *
 * java中基本类型的包装类的大部分都实现了常量池技术
 * Byte,Short,Integer,Long,Character,Boolean
 *
 * Byte,Short,Integer,Long,Character这5种整型的包装类也只是在对应值小于等于127时才可使用对象池，也即对象不负责创建和管理大于127的这些类的对象
 *
 * 设计模式:
 *    享元模式
 *
 */
public class TestInteger {

    @Test
    public void test1() {
        Integer i1 = 100;
        int j1 = 100;

        Integer i2 = 200;
        int j2 = 200;

        System.out.println(i1 == j1); // true
        System.out.println(i2 == j2); // true
    }

    @Test
    public void test2() {
        Integer i1 = 100;
        Integer j1 = 100;

        Integer i2 = 200;
        Integer j2 = 200;

        System.out.println(i1 == j1); // true
        System.out.println(i2 == j2); // false
    }

    @Test
    public void test3() {
        Integer i1 = new Integer(100);
        int j1 = 100;

        Integer i2 = new Integer(200);
        int j2 = 200;

        System.out.println(i1 == j1); // true
        System.out.println(i2 == j2); // true
    }

    @Test
    public void test4() {
        Integer i1 = new Integer(100);
        Integer j1 = 100;

        Integer i2 = new Integer(200);
        Integer j2 = 200;

        System.out.println(i1 == j1); // false
        System.out.println(i2 == j2); // false
    }


    @Test
    public void test5() {
        Integer i1 = new Integer(100);
        Integer j1 = 100;

        Integer i2 = new Integer(200);
        Integer j2 = 200;

        System.out.println(i1.equals(j1)); // true
        System.out.println(i2.equals(j2)); // true
    }


}
