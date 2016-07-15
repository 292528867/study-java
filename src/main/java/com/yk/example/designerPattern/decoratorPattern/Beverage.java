package com.yk.example.designerPattern.decoratorPattern;

/**
 * Created by yukui on 2016/7/13.
 */
public abstract class Beverage {

    String description = "Unknow Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
