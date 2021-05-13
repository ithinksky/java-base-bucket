package com.ithinksky.java.jvm;

/**
 * @author tengpeng.gao
 */
public class TestInteger {

    public static void main(String[] args) {
        TestInteger t = new TestInteger();
        System.out.println(t.plusA());
        System.out.println(t.plusB());

        Integer iA = 1;
        int iB = 1;
        System.out.println(" Intetger == int : " + (iA == iB));

        int iC = 1280;
        Integer iD = 1280;
        System.out.println(" Intetger == int : " + (iC == iD));

        Integer iE = 1280;
        System.out.println(" Intetger == int : " + (iD == iE));

    }

    public Integer plusA() {
        Integer iA = 128;
        int iB = 128;
        return iA + iB;
    }

    public Integer plusB() {
        Integer iA = 12;
        int iB = 12;
        return iA + iB;
    }


}
