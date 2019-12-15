package com.ithinksky.java.n02collections;

import java.util.*;

/**
 * iterator，如果不明白为什么就去看下源码，看看他们是怎么实现相关功能的。
 *
 * @author tengpeng.gao
 * @since 2019-02-12
 */
public class TestCollection001Iterator {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("123");
        list.add("456");
        list.add("789");

        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            String value = iterator.next();

            if (value.equals("456")) {
                // 迭代过程中不可以修改集合，抛出 ConcurrentModificationException 异常，由 modCount 控制
//                list.add("999");
                iterator.remove(); // 移除不会抛出 ConcurrentModificationException 异常，单线程下安全
            }
            System.out.println(value);
        }
        System.out.println(list);
    }

}
