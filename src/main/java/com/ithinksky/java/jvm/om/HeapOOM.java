package com.ithinksky.java.jvm.om;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * vm：参数设置
 *
 * mac:
 *  -Xmx20m -Xms20m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/tmp/jvmdebug
 *
 * win10:
 * -Xmx20m -Xms20m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=D:\jvmdebug
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
        private String msg = "hh";

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }

}

// mac 执行结果：
// java.lang.OutOfMemoryError: Java heap space
// Dumping heap to /tmp/jvmdebug/java_pid41396.hprof ...
// Heap dump file created [27853229 bytes in 0.091 secs]
// Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
//	at java.util.Arrays.copyOf(Arrays.java:3210)
//	at java.util.Arrays.copyOf(Arrays.java:3181)
//	at java.util.ArrayList.grow(ArrayList.java:265)
//	at java.util.ArrayList.ensureExplicitCapacity(ArrayList.java:239)
//	at java.util.ArrayList.ensureCapacityInternal(ArrayList.java:231)
//	at java.util.ArrayList.add(ArrayList.java:462)
//	at com.ithinksky.java.jvm.omm.HeapOOM.main(HeapOOM.java:19)
//
// Process finished with exit code 1
