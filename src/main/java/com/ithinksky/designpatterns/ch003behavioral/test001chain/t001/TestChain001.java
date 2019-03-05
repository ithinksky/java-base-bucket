package com.ithinksky.designpatterns.ch003behavioral.test001chain.t001;

/**
 * 职责链模式
 *
 * @author tengpeng.gao
 * @since 2019-02-21
 */
public class TestChain001 {

    public static void main(String[] args) {

        ConcreteHandler1 c1 = new ConcreteHandler1();
        ConcreteHandler2 c2 = new ConcreteHandler2();
        ConcreteHandler3 c3 = new ConcreteHandler3();

        c1.setSuccessor(c2);
        c2.setSuccessor(c3);
        
        int[] requests = new int[]{1, 12, 4, 5, 14, 8, 20, 40, 23, 56, 0, 10};

        for (int i = 0; i < requests.length; i++) {
            c1.handleRequest(requests[i]);
        }

    }


}
