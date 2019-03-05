package com.ithinksky.designpatterns.ch002structural.test004decorator.t001;

/**
 * @author tengpeng.gao
 * @since 2019-02-20
 */
public abstract class Decorate extends Component {

    protected Component component;

    public void decorate(Component component) {
        this.component = component;
    }
}
