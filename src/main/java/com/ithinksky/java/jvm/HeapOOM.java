package com.ithinksky.java.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * -verbose:gc -Xmx20m -Xms20m -XX:+heapDumpOnOutOfMemoryError -XX:heapDumpPath=c:/
 *
 * @author tengpeng.gao
 */
public class HeapOOM {

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }

    static class OOMObject {

    }

}
