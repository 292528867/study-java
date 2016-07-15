package com.yk.example.designerPattern.singletonPattern;

/**
 * 急切实例化(饱汉模式)
 * Created by yukui on 2016/7/15.
 */
public class Singleton1 {

     public  static Singleton1 uniqueInstance = new Singleton1();

    public static Singleton1 getInstance(){
        return uniqueInstance;
    }
}
