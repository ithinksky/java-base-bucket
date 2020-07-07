package com.ithinksky.java.jvm.om;

/**
 * vm：参数设置
 * -Xss2M
 *
 * 代码执行有较大风险，有可能造成系统假死
 *
 * @author tengpeng.gao
 */
public class JavaVMStackOOM {

    private void dontStop(){
        while (true){

        }
    }

    public void stackLeakByThread(){

        while (true){
            new Thread(()-> dontStop()).start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM javaVMStackOOM = new JavaVMStackOOM();
        javaVMStackOOM.stackLeakByThread();
    }


}
