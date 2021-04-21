package com.ithinksky.java.n02collections.list;

import com.ithinksky.java.util.GsonUtil;
import org.junit.Test;

import java.util.LinkedList;

/**
 * 数据结构为双向链表
 * 插入删除操作复杂度低，
 * 查询复杂度高，
 * 因此常用于写多读少的场景
 * <p>
 * 含有头插和尾插方法，
 * 因此常常被当做堆栈和队列使用。
 *
 * @author tengpeng.gao
 */
public class TestLinkedList {

    @Test
    public void testLinkedList() {

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(null);
        GsonUtil.print(linkedList);
    }


}
