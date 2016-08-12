package com.yk.example.proxy.staticProxy;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by yukui on 2016/8/12.
 */
public class StaticProxyTest {


    @Test
    public void test() {
        CountImp countImp = new CountImp();
        CountProxy proxy = new CountProxy(countImp);
        proxy.queryCount();
        proxy.updateCount();
    }
}