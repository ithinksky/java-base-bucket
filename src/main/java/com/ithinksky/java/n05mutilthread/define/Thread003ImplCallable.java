package com.ithinksky.java.n05mutilthread.define;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 实现 Callable 接口
 *
 * @author tengpeng.gao
 * @since 2019-02-25
 */
public class Thread003ImplCallable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        MyCallableThread myCallableThread = new MyCallableThread();
        FutureTask<String> futureTask = new FutureTask<>(myCallableThread);
        new Thread(futureTask).start();
        System.out.println("futureTask.get() ==== " + futureTask.get());

    }

}


class MyCallableThread implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("MyCallableThread implements Callable call() ");
        return "CallableResult";
    }
}
