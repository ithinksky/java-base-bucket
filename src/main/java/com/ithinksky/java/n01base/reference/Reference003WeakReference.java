package com.ithinksky.java.n01base.reference;

import java.lang.ref.WeakReference;

/**
 * 弱引用 WeakReference
 * 弱引用是一种比软引用生命周期更短的引用。
 * 他的生命周期很短，不论当前内存是否充足，
 * 都只能存活到下一次垃圾收集之前。
 * vm：-Xmx2m -Xms2m
 *
 * 生命周期很短的对象，例如ThreadLocal中的Key
 *
 * @author tengpeng.gao
 * @since 2019-02-26
 */
public class Reference003WeakReference {

    public static void main(String[] args) {
        WeakReference<String> weakReference = new WeakReference<>(new String("弱引用"));
        System.gc();
        System.runFinalization();
        if (weakReference.get() == null) {
            System.out.println("weakReference已经被GC回收");
        }
    }

}
