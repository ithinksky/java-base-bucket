package com.ithinksky.java.n02collections.set;

import org.junit.Test;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * TreeSet 基于二叉树实现
 * 1、基于二叉树实现，有序
 * 2、元素必须实现 Comparable 接口，实现 compareTo 方法，因此 元素不能存储 null
 *
 * @author tengpeng.gao
 */
public class TestTreeSet {

    @Test
    public void test() {

        TreeSet<String> treeSet = new TreeSet<>();
        System.out.println(treeSet);
        treeSet.add(null); // 抛出异常
        System.out.println(treeSet);

    }


}
