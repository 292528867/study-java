package com.yk.example.proxy.dynamic;

/**
 * \动态代理类的字节码在程序运行时由Java反射机制动态生成，无需程序员手工编写它的源代码。
 * 动态代理类不仅简化了编程工作，而且提高了软件系统的可扩展性，
 * 因为Java 反射机制可以生成任意类型的动态代理类。
 * java.lang.reflect 包中的Proxy类和InvocationHandler 接口提供了生成动态代理类的能力。
 * Created by yukui on 2016/8/3.
 */
public class TestProxy {

    public static void main(String[] args) {
        //得到生成的class文件 然后反编译得到代码 发现代理类继承proxy 实现代理接口
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        BookFacadeProxy proxy = new BookFacadeProxy();
        BookFacade bookProxy = (BookFacade) proxy.bind(new BookFacadeImpl());
        bookProxy.addBook();
        bookProxy.removeBook();
    }

}
