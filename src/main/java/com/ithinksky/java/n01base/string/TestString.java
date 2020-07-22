package com.ithinksky.java.n01base.string;

/**
 * 功能描述：
 *
 * @author tengpeng.gao
 */
public class TestString {

    public static void main(String[] args) {

        String str1 = "abc";
        String str2 = new String("abc").intern();
        String str3 = str2.intern();

        System.out.println(str1 == str2);
        System.out.println(str2 == str3);
        System.out.println(str1 == str3);

        // true
        // true
        // true
    }

    public void testA() {

        String str = "cbcAuditApp-womenClothesAuditProcess-startForm";

        str.lastIndexOf("-");
        System.out.println(str.substring(str.lastIndexOf("-") + 1));

    }

    public void testB() {

        String withdrawalAccount = "123456789";
        // 账号脱敏规则，及脱敏处理
        System.out.println(withdrawalAccount.substring(withdrawalAccount.length() - 4));
    }
}
