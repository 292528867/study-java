package com.yk.example.proxy.cglib;

/**
 * Created by yukui on 2016/8/4.
 */
public class TestCglib {

    public static void main(String[] args) {
        BookFacadeCglib bookFacadeCglib = new BookFacadeCglib();
        BookFacadeImpl1 instance = (BookFacadeImpl1) bookFacadeCglib.getInstance(new BookFacadeImpl1());
        instance.addBook();
    }
}
