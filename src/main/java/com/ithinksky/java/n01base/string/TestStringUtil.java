package com.ithinksky.java.n01base.string;

/**
 * @author tengpeng.gao
 */
public class TestStringUtil {

    public static void main(String[] args) {
        //
        String nickName = "德国大师账单";
        String replace = "大师";
        String replace1 = nickName.replace(replace, "**");
        System.out.println("nickName === " + nickName);
        System.out.println("replace1 === " + replace1);

    }

}
