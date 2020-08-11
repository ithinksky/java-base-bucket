package com.ithinksky.java.n01base.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

/**
 * vm: -Xmx2m -Xms2m
 * 总结：PhantomReference 类似强引用，它不会自动根据内存情况自动对目标对象回收，
 * 所以这里在 Heap 里不断开辟新空间，当达到 2m 阈值时，系统报出 OutOfMemoryError 异常。
 *
 * @author tengpeng.gao
 */
public class PhantomRef {

    public static void main(String[] args) {
        Reference<String>[] referent = new PhantomReference[100000];
        ReferenceQueue<String> queue = new ReferenceQueue<>();
        for (int i = 0; i < referent.length; i++) {
            referent[i] = new PhantomReference<>(new String("mybean:" + i), queue);
        }

        System.out.println(referent[100].get());
    }

    //
    // Exception in thread "main" java.lang.OutOfMemoryError: GC overhead limit exceeded
    //	at java.lang.StringBuilder.toString(StringBuilder.java:407)
    //	at com.ithinksky.java.n01base.reference.PhantomRef.main(PhantomRef.java:16)

}
