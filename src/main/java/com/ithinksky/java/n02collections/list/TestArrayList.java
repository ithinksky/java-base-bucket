package com.ithinksky.java.n02collections.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tengpeng.gao
 */
public class TestArrayList {


    @Test
    public void testNoArgCon() {
        // 使用无参构造创建对象，此时，
        // this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
        // 即 this.elementData = {}
        List<String> list = new ArrayList<>();

        // Any empty ArrayList with elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA
        // will be expanded to DEFAULT_CAPACITY when the first element is added.
        // 即 先 this.elementData = new Object[10];
        // 此时 ArrayList 容量为 10 ;
        list.add("空列表，增加第一个元素时，分配默认容量");
    }

    @Test
    public void testTrimToSize() {
        // 使用无参构造创建对象，此时，
        // this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
        // 即 this.elementData = {}
        ArrayList<String> list = new ArrayList<>();

        // Any empty ArrayList with elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA
        // will be expanded to DEFAULT_CAPACITY when the first element is added.
        // 即 先 this.elementData = new Object[10];
        // 此时 ArrayList 容量为 10 ;
        list.add("空列表，增加第一个元素时，分配默认容量");

        // 通过该方法整理空间
        // 整理后 ArrayList 容量为 1 ;
        // 相较于整理前 节省了 9个 容量。起到了优化作用
        list.trimToSize();

    }


}
