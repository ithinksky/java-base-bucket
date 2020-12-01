package com.ithinksky.java.jvm.jvm;

/**
 * javap -c XXX.class
 * 查看 class 字节码，分析执行流程
 *
 * @author tengpeng.gao
 */
public class WatchVmAttr {

    private int x = 1;
    private int y = 2;

    public static void main(String[] args) {
        WatchVmAttr attr = new WatchVmAttr();
        WatchVmAttr.work(attr.x, attr.y);
    }

    public static int work(int x, int y) {

        int z = (x + y) * 10;

        return z;
    }
}


/**
 *
 * E:\IdeaProjects\java-base-bucket\target\classes\com\ithinksky\java\jvm\jvm>javap -c WatchVmAttr.class
 * Compiled from "WatchVmAttr.java"
 * public class com.ithinksky.java.jvm.jvm.WatchVmAttr {
 *   public com.ithinksky.java.jvm.jvm.WatchVmAttr();
 *     Code:
 *        0: aload_0
 *        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 *        4: aload_0
 *        5: iconst_1
 *        6: putfield      #2                  // Field x:I
 *        9: aload_0
 *       10: iconst_2
 *       11: putfield      #3                  // Field y:I
 *       14: return
 *
 *   public static void main(java.lang.String[]);
 *     Code:
 *        0: new           #4                  // class com/ithinksky/java/jvm/jvm/WatchVmAttr
 *        3: dup
 *        4: invokespecial #5                  // Method "<init>":()V
 *        7: astore_1
 *        8: aload_1
 *        9: getfield      #2                  // Field x:I
 *       12: aload_1
 *       13: getfield      #3                  // Field y:I
 *       16: invokestatic  #6                  // Method work:(II)I
 *       19: pop
 *       20: return
 *
 *   public static int work(int, int);
 *     Code:
 *        0: iload_0
 *        1: iload_1
 *        2: iadd
 *        3: bipush        10
 *        5: imul
 *        6: istore_2
 *        7: iload_2
 *        8: ireturn
 * }
 *
 */