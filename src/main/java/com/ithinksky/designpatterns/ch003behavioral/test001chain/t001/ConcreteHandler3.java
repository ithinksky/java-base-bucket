package com.ithinksky.designpatterns.ch003behavioral.test001chain.t001;

/**
 * @author tengpeng.gao
 * @since 2019-02-21
 */
public class ConcreteHandler3 extends Handler {

    @Override
    public void handleRequest(int request) {
        if (request >= 20 && request < 30) {
            System.out.println(" ConcreteHandler3 20=-30 handle: " + request);
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}
