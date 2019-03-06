package com.ithinksky.java.n01base.init;

/**
 * 初始化执行顺序
 *
 * 静态代码块（或静态变量） > 构造代码块（或属性） > 构造方法
 *
 * 存在继承关系的，同级别父类优先于子类
 *
 * @author tengpeng.gao
 * @since 2019/3/6
 */
public class Init001Demo {

    static class B {

        public B(String name) {
            System.out.println("B 构造方法 == " + name);
        }
    }

    static class ParentA {

        B b1 = new B("ParentA");

        // 静态代码块：对象实例化就执行，无论new 多少个对象，仅执行一次；
        static {
            System.out.println("ParentA 静态块");
        }

        public ParentA() {
            System.out.println("ParentA 构造方法");
        }

        // 构造代码块：对象一实例化就执行，每实例化一次执行一次；
        {
            System.out.println("ParentA 构造代码块");
        }

    }

    static class A extends ParentA {

        B b1 = new B("A1");

        // 构造代码块：对象一实例化就执行，每实例化一次执行一次；
        {
            System.out.println("A 构造代码块");
        }

        B b2 = new B("A2");

        // 静态代码块：对象实例化就执行，无论new 多少个对象，仅执行一次；
        static {
            System.out.println("A 静态块");
        }

        public A() {
            System.out.println("A 构造方法");
        }


    }

    public static void main(String[] args) {

        new A();
        System.out.println(" ========== ");
        new A();
        // 执行结果：

        //ParentA 静态块
        //A 静态块
        //B 构造方法 == ParentA
        //ParentA 构造代码块
        //ParentA 构造方法
        //B 构造方法 == A1
        //A 构造代码块
        //B 构造方法 == A2
        //A 构造方法
        // ==========
        //B 构造方法 == ParentA
        //ParentA 构造代码块
        //ParentA 构造方法
        //B 构造方法 == A1
        //A 构造代码块
        //B 构造方法 == A2
        //A 构造方法

    }

}
