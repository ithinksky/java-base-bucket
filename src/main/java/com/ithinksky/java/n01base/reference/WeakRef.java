package com.ithinksky.java.n01base.reference;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * vm: -Xmx2m -Xms2m
 * 总结：WeakReference 与 SoftReference 具有相同的特性，
 * 也会视内存使用情况来判断是否自动回收。取第 100 个对象时，返回为 null。
 *
 * @author tengpeng.gao
 */
public class WeakRef {

    public static void main(String[] args) {
        Reference<String>[] referent = new WeakReference[10000];
        for (int i = 0; i < referent.length; i++) {
            referent[i] = new WeakReference<>(new String("mybean:" + i));
        }
        System.out.println(referent[100].get());
    }

}
