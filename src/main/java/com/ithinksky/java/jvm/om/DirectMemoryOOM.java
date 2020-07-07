package com.ithinksky.java.jvm.om;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * vm：参数设置
 *
 * -Xms20m -XX:MaxDirectMemorySize=10m
 *
 * -XX:MaxDirectMemorySize 如果不指定，则默认与Java堆得最大值（-Xmx指定）一样。
 *
 * @author tengpeng.gao
 */
public class DirectMemoryOOM {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {

        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }

    }

    // Exception in thread "main" java.lang.OutOfMemoryError

}
