package com.yk.example.designerPattern.decoratorPattern;

/**
 * Created by yukui on 2016/7/13.
 */
public class Whip extends CondimentDecotator {

    Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ",奶泡";
    }

    @Override
    public double cost() {
        return 0.1 + beverage.cost();
    }
}
