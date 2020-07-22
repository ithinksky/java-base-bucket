package com.ithinksky.java.jvm.om;

/**
 *
 * 虚拟机栈溢出
 * 1、减少空间：使用 -Xss 参数减少栈内存容量
 * 2、占用空间：方法数量，使用大量的方法填满虚拟机栈
 *
 * vm：参数设置 -Xss160k
 *
 * <p>The stack size specified is too small, Specify at least 160k Error: Could not create the Java
 * Virtual Machine. Error: A fatal exception has occurred. Program will exit.
 *
 * @author tengpeng.gao
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF javaVMStackSOF = new JavaVMStackSOF();
        try {
            javaVMStackSOF.stackLeak();
        } catch (Throwable e) {
            System.out.println("栈深度: " + javaVMStackSOF.stackLength);
            e.printStackTrace();
        }

    }


    // 执行结果:
    // Exception in thread "main" java.lang.StackOverflowError

}
