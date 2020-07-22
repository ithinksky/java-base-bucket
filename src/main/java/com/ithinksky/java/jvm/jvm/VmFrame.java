package com.ithinksky.java.jvm.jvm;

/**
 * @author tengpeng.gao
 */
public class VmFrame {

    public static void main(String[] args) {
        VmFrame v = new VmFrame();
        v.work(10);
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void work(int i){

    }

}
