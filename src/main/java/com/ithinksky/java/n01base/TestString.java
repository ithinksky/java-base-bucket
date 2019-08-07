package com.ithinksky.java.n01base;

/**
 * 功能描述：
 *
 * @author tengpeng.gao
 */
public class TestString {

    public static void main(String[] args) {

        String str = "cbcAuditApp-womenClothesAuditProcess-startForm";

        str.lastIndexOf("-");
        System.out.println(str.substring(str.lastIndexOf("-") + 1));

    }

}
