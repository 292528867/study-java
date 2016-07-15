package com.yk.example.designerPattern.singletonPattern;

/**
 *  双重检查 线程安全
 * Created by yukui on 2016/7/15.
 */
public class Singleton2 {
     //volatile 关键字确保当uniqueInstance变量被初始化singleton2实例时，多个线程正确的处理uniqueInstance变量
     public volatile static Singleton2 uniqueInstance ;

    private Singleton2(){};

    public static Singleton2 getInstance() {
        if (uniqueInstance == null) {
            synchronized (Singleton2.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton2();
                }
            }
        }
        return uniqueInstance;
    }

}
