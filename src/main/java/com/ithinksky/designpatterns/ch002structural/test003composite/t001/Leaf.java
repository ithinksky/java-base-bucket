package com.ithinksky.designpatterns.ch002structural.test003composite.t001;

/**
 * @author tengpeng.gao
 * @since 2019-02-20
 */
public class Leaf extends Component {

    public Leaf(String name) {
        setName(name);
    }

    @Override
    protected void add(Component c) {
        //叶子节点不能添加子节点,因此不做实现
    }

    @Override
    protected void remove(Component c) {
        //叶子节点不能添加子节点,因此不做实现
    }

    @Override
    protected void display(int depth) {
        String temp = "";
        for (int i = 0; i < depth; i++) {
            temp += "-";
        }
        System.out.println(temp + getName());
    }
}
