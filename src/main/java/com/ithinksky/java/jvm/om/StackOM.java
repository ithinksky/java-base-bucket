package com.ithinksky.java.jvm.om;

/**
 * vm：参数设置
 * -Xss160k
 *
 * <p>The stack size specified is too small, Specify at least 160k
 * Error: Could not create the Java Virtual Machine.
 * Error: A fatal exception has occurred. Program will exit.
 *
 * @author tengpeng.gao
 */
public class StackOM {

    public static void main(String[] args) {
        JavaVMStackSOF javaVMStackSOF = new JavaVMStackSOF();
        try {
            javaVMStackSOF.stackLeak();
        } catch (Throwable e) {
            System.out.println("栈深度: " + javaVMStackSOF.stackLength);
            e.printStackTrace();
        }

    }

    static class JavaVMStackSOF {

        private int stackLength = 1;

        public void stackLeak() {
            stackLength++;
            stackLeak();
        }
    }

    // 执行结果:
    // Exception in thread "main" java.lang.StackOverflowError

    // Xss160k  stack length:772
    // Xss170k  stack length:7702
    // Xss180k  stack length:1004

}
