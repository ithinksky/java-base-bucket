package com.ithinksky.java.jvm.jvm;

/**
 * javap -c XXX.class
 * 查看 class 字节码，分析执行流程
 *
 * @author tengpeng.gao
 */
public class WatchVmStack {
    public static void main(String[] args) {
        WatchVmStack vmStack = new WatchVmStack();
        vmStack.work();
    }
    public int work() {
        int x = 1;
        int y = 2;
        int z = (x + y) * 10;
        return z;
    }
}


/***
 *
 * E:\IdeaProjects\java-base-bucket\target\classes\com\ithinksky\java\jvm\jvm>javap -c WatchVmStack.class
 * Compiled from "WatchVmStack.java"
 * public class com.ithinksky.java.jvm.jvm.WatchVmStack {
 *   public com.ithinksky.java.jvm.jvm.WatchVmStack();
 *     Code:
 *        0: aload_0
 *        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 *        4: return
 *
 *   public static void main(java.lang.String[]);
 *     Code:
 *        0: new           #2                  // class com/ithinksky/java/jvm/jvm/WatchVmStack
 *        3: dup
 *        4: invokespecial #3                  // Method "<init>":()V
 *        7: astore_1
 *        8: aload_1
 *        9: invokevirtual #4                  // Method work:()I
 *       12: pop
 *       13: return
 *
 *   public int work();    work 方法的执行流程
 *     Code:
 *        0: iconst_1
 *        1: istore_1
 *        2: iconst_2
 *        3: istore_2
 *        4: iload_1
 *        5: iload_2
 *        6: iadd
 *        7: bipush        10
 *        9: imul
 *       10: istore_3
 *       11: iload_3
 *       12: ireturn
 * }
 *
 * E:\IdeaProjects\java-base-bucket\target\classes\com\ithinksky\java\jvm\jvm>
 *
 */