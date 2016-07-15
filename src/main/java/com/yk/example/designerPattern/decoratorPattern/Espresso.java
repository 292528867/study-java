package com.yk.example.designerPattern.decoratorPattern;

/**
 * Created by yukui on 2016/7/13.
 */
public class Espresso extends Beverage {

    public Espresso() {
        description = "浓缩咖啡";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
