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
            // 2、将游标移动至尾部
            // 3、新增的节点变为尾部节点
//            Node<E> newNode = new Node<>(item, null);
//            last.next = newNode;
//            last = newNode;
        }

        @Override
        public void delete(E e) {
            // 1、先找到存储数据的节点
            // 2、然后执行删除操作

        }

        @Override
        public void query(E e) {

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
                    System.out.println("currentNode " + currentNode.item);
                }
            }
        }


    }


    public static void main(String[] args) {

        MySingleLinkedList<String> mySingleLinkedList = new MySingleLinkedList<>(10);

        mySingleLinkedList.foreach();

    }


}
