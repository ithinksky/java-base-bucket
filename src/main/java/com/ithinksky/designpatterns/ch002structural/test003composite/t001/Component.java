package com.ithinksky.designpatterns.ch002structural.test003composite.t001;

/**
 * @author tengpeng.gao
 * @since 2019-02-20
 */
public abstract class Component {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    protected abstract void add(Component c);

    protected abstract void remove(Component c);

    protected abstract void display(int depth);
}
