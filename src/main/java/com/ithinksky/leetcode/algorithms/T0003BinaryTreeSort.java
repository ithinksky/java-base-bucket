package com.ithinksky.leetcode.algorithms;

/**
 * 类功能描述： 使用一个二叉树来实现一个 int[] 数组的插入排序
 *
 * @author: tengpeng.gao
 */
public class T0003BinaryTreeSort {

    public static void main(String[] args) {

        // 给定的数组
        int[] arr = new int[]{7, 3, 10, 12, 5, 1, 9};

        BinarySortTree sortTree = new BinarySortTree();

        int length = arr.length;
        for (int i = 0; i < length; i++) {
            sortTree.addNode(new Node(arr[i]));
        }

        // 遍历树
        sortTree.middleSort();

    }


    /**
     * 节点
     */
    static class Node {
        private Node leftNode;
        private Node rightNode;
        private int value;

        public Node(int value) {
            this.value = value;
        }

        public void add(Node node) {
            if (node == null) {
                return;
            }
            if (this.value > node.value) {
                if (this.leftNode == null) {
                    this.leftNode = node;
                } else {
                    this.leftNode.add(node);
                }
            } else {
                if (this.rightNode == null) {
                    this.rightNode = node;
                } else {
                    this.rightNode.add(node);
                }
            }
        }

        public void middleSort() {
            if (this.leftNode != null) {
                this.leftNode.middleSort();
            }
            System.out.println(this.value);
            if (this.rightNode != null) {
                this.rightNode.middleSort();
            }
        }

    }


    /**
     * 二叉树
     */
    static class BinarySortTree {
        private Node root;

        public void addNode(Node node) {
            if (root == null) {
                root = node;
            } else {
                root.add(node);
            }
        }

        public void middleSort() {
            if (root == null) {
                return;
            }
            root.middleSort();
        }
    }

}
