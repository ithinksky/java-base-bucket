package com.ithinksky.java.n01base;

/**
 * @author tengpeng.gao
 */
public class TestObject {


    public static void main(String[] args) {

        Number n = 0;
        Class<? extends Number> c = n.getClass();



        // 不同的对象有了相同的hash code 2112
        String a = "Aa";
        String b = "BB";
        int aa = a.hashCode();
        int bb = b.hashCode();

        System.out.println(aa);
        System.out.println(bb);

    }


    public static class A {

        private void test() {

        }


    }

    public static class B extends A {

        private void test() {

        }


    }


}
