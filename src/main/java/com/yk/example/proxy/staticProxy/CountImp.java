package com.yk.example.proxy.staticProxy;

/**
 * 委托类(包含业务逻辑)
 * Created by yukui on 2016/8/3.
 */
public class CountImp implements Count {
    @Override
    public void queryCount() {
        System.out.println("查看账户方法...");
    }

    @Override
    public void updateCount() {
        System.out.println("修改账户方法...");
    }
}
