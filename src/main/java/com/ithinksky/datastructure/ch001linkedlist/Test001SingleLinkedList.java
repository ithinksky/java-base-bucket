package com.ithinksky.datastructure.ch001linkedlist;

import com.ithinksky.datastructure.ICommonDataOperate;

/**
 * 功能描述：单链表的定义及相关操作
 *
 * @author tengpeng.gao
 * @since 2019/4/2
 */
public class Test001SingleLinkedList {

    public static class MySingleLinkedList<E> implements ICommonDataOperate<E> {

        // 头节点
        Node<E> first;

        // 尾节点
        Node<E> last;

        public MySingleLinkedList() {
            // 默认为空链表
        }

        public MySingleLinkedList(int length) {
            // 初始化 length 长度的链表，节点内容为 null
            for (int i = 1; i <= length; i++) {
                this.add(null);
            }
        }

        private static class Node<E> {
            E item;
            Node<E> next;

            Node(E element, Node<E> next) {
                this.item = element;
                this.next = next;
            }
        }

        public void add(E item) {
            // 1、默认在尾部追加
            // 2、将游标移动至尾部（或维护尾部节点引用）
            // 3、新增的节点变为尾部节点

            // 如果是空链表，
            // 则插入的第一个节点即为头部节点，也为尾部节点
            if (this.first == null) {
                this.first = new Node<>(item, null);
                this.last = this.first;
            } else {
                Node<E> newNode = new Node<>(item, null);
                last.next = newNode;
                last = newNode;
            }

        }

        @Override
        public void delete(E e) {
            // 1、先找到存储数据的节点
            // 2、找到数据节点的上一个节点和下一个节点（头节点和尾节点情况除外）
            // 3、然后执行删除操作
            // TODO
        }

        @Override
        public void query(E e) {
            if (first == null) {
                System.out.println("空链表");
            } else {
                Node<E> currentNode = first;
                E item = first.item;
                if (item != null && item.equals(e)) {
                    System.out.println("找到数据：" + e);
                    return;
                }

                // 遍历节点，对比节点内容与所查询内容
                while (currentNode.next != null) {
                    currentNode = currentNode.next;
                    item = currentNode.item;
                    if (item != null && item.equals(e)) {
                        System.out.println("找到数据：" + e);
                        return;
                    }
                }
            }
            System.out.println("未找到数据：" + e);
        }

        @Override
        public void foreach() {
            if (first == null) {
                System.out.println("空链表");
            } else {
                Node<E> currentNode = first;
                System.out.println("first " + first.item);
                while (currentNode.next != null) {
                    currentNode = currentNode.next;
                    System.out.println("currentNode.item " + currentNode.item);
                }
            }
        }


    }


    public static void main(String[] args) {

        MySingleLinkedList<String> mySingleLinkedList = new MySingleLinkedList<>(10);

        // 遍历
        mySingleLinkedList.foreach();

        // 增加
        mySingleLinkedList.add("A");
        mySingleLinkedList.add("B");
        mySingleLinkedList.add("C");
        mySingleLinkedList.add("D");
        mySingleLinkedList.foreach();

        // 查找
        mySingleLinkedList.query("X");


    }


}
