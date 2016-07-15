package com.yk.example.designerPattern.singletonPattern;

/**
 *  懒汉模式
 * Created by yukui on 2016/7/15.
 */
public class Singleton {

    public static Singleton uniqueInstance ;

    /**
     * 私有构造函数 只有自身可以调用
     */
    private Singleton(){}

    /**
     * synchronized 保证线程安全 但影响了性能 不加synchronized非线程安全
     * @return
     */
    public  static synchronized Singleton getInstance() {
        if (uniqueInstance == null) {
            //如果我们不需要这个实例，它永远不会产生，这就是延迟实例化
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                System.out.println(Singleton.getInstance());
            }
        };
    }
}
