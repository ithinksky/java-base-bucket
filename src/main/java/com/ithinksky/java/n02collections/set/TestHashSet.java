package com.ithinksky.java.n02collections.set;

import org.junit.Test;

import java.util.HashSet;

/**
 * HashSet 基于 HashMap 实现， 无序
 *
 * @author tengpeng.gao
 */
public class TestHashSet {


    @Test
    public void test() {

        HashSet<String> hashSet = new HashSet<>();
        System.out.println(hashSet);
        hashSet.add(null);
        System.out.println(hashSet);

    }


}
