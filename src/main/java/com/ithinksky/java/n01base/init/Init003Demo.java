package com.ithinksky.java.n01base.init;

/**
 * 初始化执行顺序
 *
 * @author tengpeng.gao
 * @since 2019/3/6
 */
public class Init003Demo {

    static class B {
        public B(String name) {
            System.out.println(name + " == B：构造方法");
        }
    }

    static class A {

        B b3 = new B("A：非静态属性 - b3");

        static B b1 = new B("A：静态属性 - b1");

        static {
            System.out.println("A：静态代码块");
        }

        static B b2 = new B("A：静态属性 - b2");

        // 非静态代码块：对象一实例化就执行，每实例化一次执行一次；
        {
            System.out.println("A：非静态代码块");
        }

        public A() {
            System.out.println("A：构造方法");
        }

    }

    public static void main(String[] args) {

        new A();
        System.out.println(" ========== ");
        new A();
        //执行结果：
        //A：静态属性 - b1 == B：构造方法
        //A：静态代码块
        //A：静态属性 - b2 == B：构造方法
        //A：非静态属性 - b3 == B：构造方法
        //A：非静态代码块
        //A：构造方法
        // ==========
        //A：非静态属性 - b3 == B：构造方法
        //A：非静态代码块
        //A：构造方法

        // 结论：
        // 1、在同一个类中，静态代码块与静态属性 是按照出现顺序初始化的，
        // 2、在同一个类中，非静态代码块与非静态属性 是按照出现顺序初始化的，
        // 3、在同一个类中，非静态代码块与非静态属性 是优先构造方法初始化的，
        // 4、在同一个类中，静态代码块与静态属性 是优先于非静态代码块与非静态属性的。
    }

}
