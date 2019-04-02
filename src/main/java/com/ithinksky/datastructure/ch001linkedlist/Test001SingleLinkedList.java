package com.ithinksky.datastructure.ch001linkedlist;

/**
 * 功能描述：单链表的定义及相关操作
 *
 * @author tengpeng.gao
 * @since 2019/4/2
 */
public class Test001SingleLinkedList {


    public static class MySingleLinkedList<E> {

        Node<E> first;

        private static class Node<E> {
            E item;
            MySingleLinkedList.Node<E> next;

            Node(E element, MySingleLinkedList.Node<E> next) {
                this.item = element;
                this.next = next;
            }
        }

        public void add(E item){
            // 1、默认在尾部追加
            // 2、将游标移动至尾部
            // 3、



        }
    }


    public static void main(String[] args) {


    }


}
