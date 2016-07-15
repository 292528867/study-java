package com.yk.example.designerPattern.decoratorPattern;

/**
 * Created by yukui on 2016/7/13.
 */
public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "综合咖啡";
    }

    @Override
    public double cost() {
        return 0.98;
    }
}
