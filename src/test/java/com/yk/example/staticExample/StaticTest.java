package com.yk.example.staticExample;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by yukui on 2016/8/12.
 */
public class StaticTest {

    @Test
    public void test() {
        /**
         * 先执行父类的静态块，再执行子类的静态块，然后执行父类的构造块和构造函数，再执行子类的构造块和构造函数
         */
        Child child = new Child();
        System.out.println(child.getName());
    }
}