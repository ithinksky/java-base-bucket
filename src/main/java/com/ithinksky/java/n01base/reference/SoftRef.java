package com.ithinksky.java.n01base.reference;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;

/**
 * vm: -Xmx2m -Xms2m
 * 总结：在新开辟 10000 个 Bean 对象时，由于软引用会视内存使用情况来判断是否自动回收，
 * 所以当最大 Heap 阈值达到 2m 时，系统自动回收最前面开辟的对象，取第 100 个对象时，返回为 null。
 * @author tengpeng.gao
 */
public class SoftRef {

    public static void main(String[] args) {
        Reference<String>[] referent = new SoftReference[10000];
        for (int i = 0; i < referent.length; i++) {
            referent[i] = new SoftReference<>(new String("mybean:" + i));
        }
        System.out.println(referent[100].get());
    }

}
