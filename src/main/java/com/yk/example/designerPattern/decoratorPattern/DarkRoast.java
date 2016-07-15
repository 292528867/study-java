package com.yk.example.designerPattern.decoratorPattern;

/**
 * Created by yukui on 2016/7/13.
 */
public class DarkRoast extends Beverage {

    public DarkRoast() {
        description = "深焙咖啡";
    }

    @Override
    public double cost() {
        return 0.99;
    }

}
