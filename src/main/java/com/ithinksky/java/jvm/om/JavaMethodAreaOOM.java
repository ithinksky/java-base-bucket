package com.ithinksky.java.jvm.om;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * vm：参数设置
 *  -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m
 *
 * @author tengpeng.gao
 */
public class JavaMethodAreaOOM {

    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor) (obj, method, args1, proxy) -> proxy.invokeSuper(obj, args1));
            enhancer.create();
        }
    }

    static class OOMObject {

    }

    // Exception in thread "main" java.lang.OutOfMemoryError: Metaspace

}
