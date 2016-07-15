package com.yk.example.designerPattern.decoratorPattern;

/**
 * Created by yukui on 2016/7/13.
 */
public class Mocha extends CondimentDecotator {

    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription()+", 摩卡";
    }

    @Override
    public double cost() {
        return 0.2 + beverage.cost();
    }
}
