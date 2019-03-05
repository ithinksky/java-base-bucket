package com.ithinksky.designpatterns.ch002structural.test003composite.t001;

/**
 * 组合模式
 *
 * @author tengpeng.gao
 * @since 2019-02-20
 */
public class TestComposite001 {

    public static void main(String[] args) {
        Component root = new Composite("根节点");

        Component leftChild = new Composite("左节点");
        Component rightChild = new Composite("右节点");

        Component leftChild_1 = new Leaf("左节点-叶子1");
        Component leftChild_2 = new Leaf("左节点-叶子2");

        Component rightChild_leaf = new Leaf("右节点—叶子");

        leftChild.add(leftChild_1);
        leftChild.add(leftChild_2);

        rightChild.add(rightChild_leaf);

        root.add(leftChild);
        root.add(rightChild);

        root.display(1);
    }

}
