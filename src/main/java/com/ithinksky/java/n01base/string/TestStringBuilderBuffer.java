package com.ithinksky.java.n01base.string;

/**
 * @author tengpeng.gao
 */
public class TestStringBuilderBuffer {

    public static void main(String[] args) {

        int n = 100;

        long stringStartTime = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < n; i++) {
            str += "." + i;
        }
        System.out.println("String 使用的时间"
                + (System.currentTimeMillis() - stringStartTime) / 1000.0 + "s");


        long sbStartTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("." + i);
        }
        System.out.println("StringBuilder 使用的时间"
                + (System.currentTimeMillis() - sbStartTime) / 1000.0 + "s");

        long sbfStartTime = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sbf.append("." + i);
        }
        System.out.println("StringBuffer 使用的时间"
                + (System.currentTimeMillis() - sbfStartTime) / 1000.0 + "s");


        // > 多次执行上述代码
        //结果一：
        //String 使用的时间0.334s
        //StringBuilder 使用的时间0.002s
        //StringBuffer 使用的时间0.001s
        //
        //结果二：
        //String 使用的时间0.323s
        //StringBuilder 使用的时间0.001s
        //StringBuffer 使用的时间0.002s
        //
        //
        //将执行次数调整至100次，多次执行结果基本上为：
        //String 使用的时间0.001s
        //StringBuilder 使用的时间0.0s
        //StringBuffer 使用的时间0.0s
        //
        //
        //> 结果分析：
        //> 在大量操作下，String 执行速度最慢。
        //> 在少量操作下，三者之间差异不大。
        //> 在同量级下的操作，执行速度一般为 StringBuilder  > StringBuffer > String。
        //现代JVM经过良好性能优化 StringBuilder 和 StringBuffer 一般情况下差异不大，
        //由于执行环境的不同， StringBuffer 的执行速度还有可能比 StringBuilder 快。

    }

}
