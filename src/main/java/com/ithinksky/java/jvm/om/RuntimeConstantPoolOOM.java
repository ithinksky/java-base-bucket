package com.ithinksky.java.jvm.om;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * vm：参数设置
 * -Xmx20m -Xms20m -XX:MetaspaceSize=10M -XX:MaxMetaspaceSize=10M
 *  // -XX:MaxDirectMemorySize 如果不指定，则默认与Java堆得最大值（-Xmx指定）一样。
 *
 * 运行时常量池溢出
 *
 * 设置-XX:PermSize=1M -XX:MaxPermSize=1M，发现没有内存溢出效果
 * 因为JDK8已经移除了永生代，而对于存放类的元数据的内存大小的设置变为Metaspace参数
 * 要通过参数 -XX:MetaspaceSize 和 -XX:MaxMetaspaceSize 设定大小。更改以后正常测试得到内存溢出，
 *
 * @author tengpeng.gao
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        try {
            // 使用 List 保持着常量池引用，避免 Full GC 回收常量池行为
            List<String> list = new ArrayList<>();
            // 10MB 的 PermSize 在 integer 范围内足够产生 OOM 了
            int item = 0;
            while (true) {
                list.add(String.valueOf(item++).intern());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    // Exception in thread "main" java.lang.OutOfMemoryError: GC overhead limit exceeded

}
