package com.ithinksky.java.n01base.string;

import org.junit.Test;

/**
 * 功能描述：
 *
 * @author tengpeng.gao
 */
public class TestString {

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
}
