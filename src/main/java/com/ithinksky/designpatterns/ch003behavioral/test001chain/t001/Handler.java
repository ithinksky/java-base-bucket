package com.ithinksky.designpatterns.ch003behavioral.test001chain.t001;

/**
 * @author tengpeng.gao
 * @since 2019-02-21
 */
public abstract class Handler {

    protected Handler successor;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public abstract void handleRequest(int request);

}
