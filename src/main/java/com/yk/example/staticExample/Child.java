package com.yk.example.staticExample;

/**
 * Created by yukui on 2016/7/27.
 */
public class Child extends Parent {

    private static String name = "child";

    /**
     * 子类的构造方法，不管这个构造方法带不带参数，默认的它都会先去寻找父类的不带参数的构造方法
     * 如果父类没有默认的无参构造函数，子类必须用super调用父类的有参构造函数
     */
   /* public Child() {
        super("");
    }*/
    public Child() {
        System.out.println(" child constructor");
    }

    {
        System.out.println(" block child ");
    }

    static {
        System.out.println(" static child");
    }

    public static void main(String[] args) {
        /**
         * 先执行父类的静态块，再执行子类的静态块，然后执行父类的构造块和构造函数，再执行子类的构造块和构造函数
         */
        Child child = new Child();
        System.out.println(child.getName());
    }
}
