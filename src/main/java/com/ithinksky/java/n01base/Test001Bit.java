package com.ithinksky.java.n01base;

/**
 * 位运算
 *
 * @author tengpeng.gao
 * @since 2019-02-22
 */
public class Test001Bit {

    public static void main(String[] args) {

        System.out.println("左移 ");
        // m<<n的含义:把整数m表示的二进制数左移n位,高位移出n位都舍弃，低位补0.  (此时将会出现正数变成负数的可能)
        // m<<n即在数字没有溢出的前提下，对于正数和负数，左移n位都相当于m乘以2的n次方.
        int i = 5 << 2;
        System.out.println("5 << 2 === " + i);
        // 5 << 2 === 20

        i = 5 << 29;
        System.out.println("5 << 29 === " + i);
        // 5 << 29 === -1610612736

        System.out.println("右移 ");
        // m>>n的含义:把整数m表示的二进制数右移n位,m为正数，高位全部补0；m为负数，高位全部补1
        int j = 5 >> 2;
        System.out.println("5 >> 2 === " + j);
        // 5 >> 2 === 1

        j = -5 >> 2;
        System.out.println("-5 >> 2 === " + j);
        // -5 >> 2 === -2


        System.out.println("无符号右移 ");
        int g = 5>>>2 ;
        System.out.println("5 >>> 2 === " + g);
        // 5 >>> 2 === 1

        g = -5 >>> 2;
        System.out.println("-5 >>> 2 === " + g);
        // -5 >>> 2 === 1073741822

        System.out.println("按位非操作（～） ");
        System.out.println("~(-5) === " + ~(-5));
        // ~(-5) === 4

    }

}
