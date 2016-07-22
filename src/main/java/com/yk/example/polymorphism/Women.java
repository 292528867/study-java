package com.yk.example.polymorphism;

/**
 * Created by yukui on 2016/7/22.
 */
public class Women extends Person {

/*    public void longHair (){
        System.out.println("女人的头发比男人长");
    }*/

    @Override
    public void canSay() {
        System.out.println("女人的头发比男人长");
    }
}
