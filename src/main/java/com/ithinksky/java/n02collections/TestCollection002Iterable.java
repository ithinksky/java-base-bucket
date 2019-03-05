package com.ithinksky.java.n02collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * iterable 接口，只要集成该接口就可以使用 for-each 形式进行数据处理
 *
 * @author tengpeng.gao
 * @since 2019-02-12
 */
public class TestCollection002Iterable {

    public static void main(String[] args) {

        Collection<String> set = new HashSet<>();
        Collection<String> list = new ArrayList<>();

        set.add("a");
        set.add("a");
        set.add("b");
        set.add("c");

        list.add("a");
        list.add("a");
        list.add("b");
        list.add("c");

        for (String setEle : set) {
            System.out.println(setEle);
        }

        System.out.println(" =========================== ");

        for (String listEle : list) {
            System.out.println(listEle);
        }

    }

}
