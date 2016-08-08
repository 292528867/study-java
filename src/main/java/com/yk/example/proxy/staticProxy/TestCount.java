package com.yk.example.proxy.staticProxy;

/**
 * Created by yukui on 2016/8/3.
 */
public class TestCount {

    public static void main(String[] args) {
        CountImp countImp = new CountImp();
        CountProxy proxy = new CountProxy(countImp);
        proxy.queryCount();
        proxy.updateCount();
    }
}
