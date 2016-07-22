package com.yk.example.polymorphism;

/**
 * Created by yukui on 2016/7/22.
 */
public class Man extends Person {

    /* public void hasHuxu() {
         System.out.println("男人都有胡须");
     }
*/
    @Override
    public void canSay() {
        System.out.println("男人都有胡须");
    }
}
