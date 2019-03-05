package com.ithinksky.java.n05mutilthread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * Java 天生是多线程的
 *
 * @author tengpeng.gao
 * @since 2019-02-25
 */
public class OnlyMain {

    public static void main(String[] args) {

        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for (int i = 0; i < threadInfos.length; i++) {
            System.out.println(threadInfos[i].getThreadId() + " " + threadInfos[i].getThreadName());
        }

    }

}
