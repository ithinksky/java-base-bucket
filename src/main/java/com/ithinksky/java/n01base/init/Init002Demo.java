package com.ithinksky.java.n01base.init;

/**
 * 初始化执行顺序
 *
 * @author tengpeng.gao
 * @since 2019/3/6
 */
public class Init002Demo {

    static class B {

        public B(String name) {
            System.out.println(name + " == B：构造方法");
        }
    }

    static class ParentA {

        B b1 = new B("ParentA：属性 - b1");


        public ParentA() {
            System.out.println("ParentA：构造方法");
        }

        // 非静态代码块：对象一实例化就执行，每实例化一次执行一次；
        {
            System.out.println("ParentA：非静态代码块");
        }

        B b2 = new B("ParentA：属性 - b2");


    }

    static class A extends ParentA {

        B b1 = new B("A：属性 - b1");

        B b2 = new B("A：属性 - b2");

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
        // 执行结果：
        //ParentA：属性 - b1 == B：构造方法
        //ParentA：非静态代码块
        //ParentA：属性 - b2 == B：构造方法
        //ParentA：构造方法
        //A：属性 - b1 == B：构造方法
        //A：属性 - b2 == B：构造方法
        //A：非静态代码块
        //A：构造方法
        // ==========
        //ParentA：属性 - b1 == B：构造方法
        //ParentA：非静态代码块
        //ParentA：属性 - b2 == B：构造方法
        //ParentA：构造方法
        //A：属性 - b1 == B：构造方法
        //A：属性 - b2 == B：构造方法
        //A：非静态代码块
        //A：构造方法

        // 结论：
        // 1、在同一个类中，非静态代码块与非静态属性 是按照出现顺序初始化的，
        // 2、在同一个类中，非静态代码块与非静态属性 是优先构造方法初始化的。
        // 3、在有继承关系的类中，按照1、2规则优先初始化父类的，然后再按照1、2规则初始化子类的。
    }

}
