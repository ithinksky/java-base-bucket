package com.ithinksky.java.n02collections.map;

import org.junit.Test;

import java.util.HashMap;

/**
 * HashMap
 * 1、key 和 value 都可以为 null
 * 2、多次为相同的 key 赋值 ，只保留最后一次赋值结果（值覆盖）
 * 3、key 必须重写 hashCode 和 equals 方法
 * 4、相关默认值
 * - 初始化容量  1 << 4 16
 * - 负载因子 .75f
 * - 最大容量 1 << 30
 * - 树化 阈值 8
 * - 析解树 阈值  6
 * 5、Node 数据结构 单链表
 * - final hash 用于定位数组
 * - final key 和 hash 值一起判定两个元素是否相同
 * - value
 * - next
 *
 * 6、TreeNode 数据结构 红黑树
 *
 * 7、Node （单链表） 和 TreeNode（红黑树） 分析
 *
 * 8、扩容机制
 *
 * 9、迭代（线程安全相关）
 *
 * @author tengpeng.gao
 */
public class TestHashMap {

    @Test
    public void test() {

        HashMap<String, String> hashMap = new HashMap<>(1 << 4);
        hashMap.put(null, null);
        hashMap.put(null, "null-d");
        hashMap.put("null", null);
        hashMap.put("", null);
        hashMap.get(null);

        System.out.println(hashMap.size());
        System.out.println(hashMap);

    }


}
