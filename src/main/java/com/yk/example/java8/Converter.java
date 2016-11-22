package com.yk.example.java8;

/**
 *  函数式接口(必须要有且仅有一个抽象方法声明)，如果有第二个抽象方法的话编译器抛异常
 *  注意不写@FunctionalInterface 程序也是正确的
 * Created by yukui on 2016/11/21.
 */
@FunctionalInterface
public interface Converter<F, T> {
    T converter(F from);
}
