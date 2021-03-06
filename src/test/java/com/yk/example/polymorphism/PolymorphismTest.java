package com.yk.example.polymorphism;

import org.junit.Test;

/**
 *
 * Created by yukui on 2016/8/12.
 */
public class PolymorphismTest {

    /**
     *  多态就是指程序中定义的引用变量所指向的具体类型和通过该引用变量发出的方法调用在编程时并不确定，
     *  而是在程序运行期间才确定，即一个引用变量倒底会指向哪个类的实例对象，
     *  该引用变量发出的方法调用到底是哪个类中实现的方法，必须在由程序运行期间才能决定。因为在程序运行时才确定具体的类
     *  ，这样，不用修改源程序代码，就可以让引用变量绑定到各种不同的类实现上，从而导致该引用调用的具体方法随之改变
     *  ，即不修改程序代码就可以改变程序运行时所绑定的具体代码，让程序可以选择多个运行状态，这就是多态性。
     */
    @Test
     public void test() {
        Person p1 = new Man(); //向上转型
        Person p2 = new Women();
        p1.canSay();
        p2.canSay();
     }
}