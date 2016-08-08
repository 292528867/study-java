package com.yk.example.proxy.staticProxy;

/**
 * Created by yukui on 2016/8/3.
 */
public class CountProxy implements Count {

    private CountImp countImp;

    public CountProxy(CountImp countImp) {
        this.countImp = countImp;
    }

    @Override
    public void queryCount() {
        System.out.println("事务处理之前");
        // 调用委托类的方法;
        countImp.queryCount();
        System.out.println("事务处理之后");
    }

    @Override
    public void updateCount() {
        System.out.println("事务处理之前");
        // 调用委托类的方法;
        countImp.updateCount();
        System.out.println("事务处理之后");
    }
}
