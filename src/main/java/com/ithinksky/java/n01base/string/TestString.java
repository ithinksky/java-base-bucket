package com.ithinksky.java.n01base.string;

import org.junit.Test;

/**
 * 功能描述：
 *
 * @author tengpeng.gao
 */
public class TestString {

    @Test
    public void test() {

        String str1 = "abc";
        String str2 = new String("abc");
        String str3 = str2.intern();
        String str4 = "abc";

        System.out.println(str1 == str2); // false
        System.out.println(str2 == str3); // false
        System.out.println(str1 == str3); // true
        System.out.println(str1 == str4); // true

    }

    @Test
    public void testA() {

        String str = "cbcAuditApp-womenClothesAuditProcess-startForm";

        str.lastIndexOf("-");
        System.out.println(str.substring(str.lastIndexOf("-") + 1));

    }



    @Test
    public void testB() {

        String withdrawalAccount = "123456789";
        // 账号脱敏规则，及脱敏处理
        System.out.println(withdrawalAccount.substring(withdrawalAccount.length() - 4));
    }

    @Test
    public void testNull() {

//        String str = new String(null);

    }

}
