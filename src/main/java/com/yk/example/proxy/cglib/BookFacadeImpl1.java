package com.yk.example.proxy.cglib;

/**
 * Created by yukui on 2016/8/4.
 */
public class BookFacadeImpl1 implements BookFacade {
    @Override
    public void addBook() {
        System.out.println("添加图书方法。。。。。");
    }
}
