package com.ithinksky.designpatterns.ch003behavioral.test001chain.t001;

/**
 * @author tengpeng.gao
 * @since 2019-02-21
 */
public class ConcreteHandler1 extends Handler {

    @Override
    public void handleRequest(int request) {
        if (request >= 0 && request < 10) {
            System.out.println(" ConcreteHandler1 0=-10 handle: " + request);
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}
