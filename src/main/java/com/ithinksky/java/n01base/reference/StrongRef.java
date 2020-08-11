package com.ithinksky.java.n01base.reference;

/**
 * vm: -Xmx1m -Xms1m
 *
 * 总结：在新开辟 100000 个 Bean 对象时，由于强引用永远不会被系统回收，当最大 Heap 阈值达到 1m 时，系统就会报出 Heap 不足的异常。
 *
 * @author tengpeng.gao
 */
public class StrongRef {

    public static void main(String[] args) {
        String[] referent = new String[100000];
        for (int i = 0; i < referent.length; i++) {
            referent[i] = new String("mybean:" + i);
        }
    }

    //
    // Exception in thread "main" java.lang.OutOfMemoryError: GC overhead limit exceeded
    //	at java.lang.AbstractStringBuilder.<init>(AbstractStringBuilder.java:68)
    //	at java.lang.StringBuilder.<init>(StringBuilder.java:89)
    //	at com.ithinksky.java.n01base.reference.StrongRef.main(StrongRef.java:11)

}
