package com.ithinksky.java.n01base.reference;

/**
 * 强引用
 * StrongRerence这个类并不存在，
 * 而是在JVM底层实现。默认的对象都是强引用类型
 * <p>
 * vm：-Xmx2m -Xms2m
 *
 * @author tengpeng.gao
 * @since 2019-02-26
 */
public class Reference001StrongReference {

    public static void main(String[] args) {
        String str = "强引用";
        System.gc();
        System.runFinalization();

        // "强引用”
        System.out.println(str);
    }

}
