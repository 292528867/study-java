package com.yk.example.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk 动态代理类
 * 程序运行的过程中，根据被代理的接口来动态生成代理类的class文件，并加载运行的过程
 * JDK提供了java.lang.reflect.Proxy类来实现动态代理的，可通过它的newProxyInstance来获得代理实现类。
 * 同时对于代理的接口的实际处理，是一个java.lang.reflect.InvocationHandler，
 * 它提供了一个invoke方法供实现者提供相应的代理逻辑的实现。可以对实际的实现进行一些特殊的处理，像Spring AOP中的各种advice。
 * Created by yukui on 2016/8/3.
 */
public class BookFacadeProxy implements InvocationHandler {

    private Object target;

    /**
     * 绑定一个委托对象并返回一个代理类
     * @param target
     * @return
     */
    public Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader()
                , target.getClass().getInterfaces(), this);
    }

    /**
     * 调用方法
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result=null;
        System.out.println("事物开始");
        result = method.invoke(target, args);
        System.out.println("事物结束");
        return result;
    }
}
