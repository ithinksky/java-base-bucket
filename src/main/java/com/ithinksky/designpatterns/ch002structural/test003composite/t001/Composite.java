package com.ithinksky.designpatterns.ch002structural.test003composite.t001;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tengpeng.gao
 * @since 2019-02-20
 */
public class Composite extends Component {
    private List<Component> children = new ArrayList<>();

    public Composite(String name) {
        setName(name);
    }

    @Override
    protected void add(Component c) {
        children.add(c);
    }

    @Override
    protected void remove(Component c) {
        children.remove(c);
    }

    @Override
    protected void display(int depth) {
        String temp = "";
        for (int i = 0; i < depth; i++) {
            temp += "-";
        }
        System.out.println(temp + getName());

        for (Component child : children) {
            child.display(depth + 2);
        }
    }
}
