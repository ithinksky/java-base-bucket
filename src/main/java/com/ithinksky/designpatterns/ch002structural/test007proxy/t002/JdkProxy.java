package com.ithinksky.designpatterns.ch002structural.test007proxy.t002;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理类
 *
 * @author tengpeng.gao
 * @since 2019-02-21
 */
public class JdkProxy implements InvocationHandler {

    private Subject realSubject;

    public Subject newProxy(Subject realSubject) {
        this.realSubject = realSubject;
        return (Subject) Proxy.newProxyInstance(realSubject.getClass().getClassLoader(),
                realSubject.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.print("say: ");
        Object result = method.invoke(realSubject, args);
        return result;
    }

}
