package com.yk.example.designerPattern.decoratorPattern;

/**
 * Created by yukui on 2016/7/13.
 */
public class Decat extends Beverage {

    public Decat() {
        description = "低咖啡因";
    }

    @Override
    public double cost() {
        return 1.05;
    }

}
