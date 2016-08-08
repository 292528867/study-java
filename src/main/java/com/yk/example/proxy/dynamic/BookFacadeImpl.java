package com.yk.example.proxy.dynamic;

/**
 * Created by yukui on 2016/8/3.
 */
public class BookFacadeImpl implements BookFacade {
    @Override
    public void addBook() {
        System.out.println("增加图书方法。。。");
    }

    @Override
    public void removeBook() {
        System.out.println("移除图书方法。。。。");
    }
}
