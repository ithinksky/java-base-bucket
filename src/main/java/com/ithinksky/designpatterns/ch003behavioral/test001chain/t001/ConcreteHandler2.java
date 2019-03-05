package com.ithinksky.designpatterns.ch003behavioral.test001chain.t001;

/**
 * @author tengpeng.gao
 * @since 2019-02-21
 */
public class ConcreteHandler2 extends Handler {

    @Override
    public void handleRequest(int request) {
        if (request >= 10 && request < 20) {
            System.out.println(" ConcreteHandler2 10=-20 handle: " + request);
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}
