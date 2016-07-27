package com.yk.example.staticExample;

/**
 * Created by yukui on 2016/7/27.
 */
public class Parent {

    private static String name = "parent";

    public String desc;

    public Parent() {
        System.out.println(" parent constructor ");
    }

    public Parent(String desc) {
        this.desc = desc;
    }

    //构造块，在创建对象时会调用，每次创建对象时会被调用，并且优先于类构造函数执行
    {
        System.out.println("block parent ");
    }

    //静态块，只会被执行一次(第一次加载此类时执行,比如说用Class.forName("")加载类时就会执行)，优于构造块
    static {
        System.out.println("  static parent ");
    }

    public static String getName() {
        return name;
    }

  /*  public static void main(String[] args) {
        Parent parent = new Parent();
    }*/
}
