package com.yk.example.proxy.cglib;

import org.junit.Test;

/**
 * Created by yukui on 2016/8/12.
 */
public class CglibTest {

    @Test
    public void test() {
        BookFacadeCglib bookFacadeCglib = new BookFacadeCglib();
        BookFacadeImpl1 instance = (BookFacadeImpl1) bookFacadeCglib.getInstance(new BookFacadeImpl1());
        instance.addBook();
    }


}