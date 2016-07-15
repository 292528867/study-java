package com.yk.example.designerPattern.strategyPattern.duck;


import com.yk.example.designerPattern.strategyPattern.fly.FlyBehavior;
import com.yk.example.designerPattern.strategyPattern.fly.FlyRocket;

/**
 * Created by yukui on 2016/7/13.
 */
public class DuckTest {
    public static void main(String[] args) {
        MallardDuck md = new MallardDuck();
        md.display();
        md.swim();
        md.performQuack();
        md.perfromFly();
        FlyBehavior fBehavior = new FlyRocket(); //向上转型
        md.setFlyBehavior(fBehavior);//改变md的飞行行为
        md.perfromFly();
        RedHeadDuck rhd = new RedHeadDuck();
        rhd.display();
        rhd.swim();
        rhd.performQuack();
        rhd.perfromFly();
    }
}