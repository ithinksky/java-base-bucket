package com.ithinksky.java.n02collections.set;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * LinkedHashSet 继承 HashSet，HashMap实现数据存储，双向链表记录顺序
 * 底层使用 LinkedHashMap 存储数据
 *
 * @author tengpeng.gao
 */
public class TestLinkedHashSet {


    @Test
    public void test() {

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        System.out.println(linkedHashSet);
        linkedHashSet.add(null);
        System.out.println(linkedHashSet);

    }


}
