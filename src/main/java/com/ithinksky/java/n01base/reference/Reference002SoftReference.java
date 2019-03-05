package com.ithinksky.java.n01base.reference;

import java.lang.ref.SoftReference;

/**
 * 软引用 SoftReference
 * 软引用是一种比强引用生命周期稍弱的一种引用类型。
 * 在JVM内存充足的情况下，软引用并不会被垃圾回收器回收，
 * 只有在JVM内存不足的情况下，才会被垃圾回收器回收。
 *
 * 所以软引用的这种特性，一般用来实现一些内存敏感的缓存，
 * 只要内存空间足够，对象就会保持不被回收掉，比如网页缓存、图片缓存等
 *
 * @author tengpeng.gao
 * @since 2019-02-26
 */
public class Reference002SoftReference {

    public static void main(String[] args) {
        SoftReference<String> softReference = new SoftReference<>(new String("软引用"));
        System.out.println(softReference.get());
    }

}
