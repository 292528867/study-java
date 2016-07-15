package com.yk.example.designerPattern.decoratorPattern;

/**
 * Created by yukui on 2016/7/13.
 */
public class BeverageTest {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " cost $" + beverage.cost());

        Beverage beverage1 = new DarkRoast();
        beverage1 = new Mocha(beverage1);
        beverage1 = new Mocha(beverage1);
        beverage1 = new Whip(beverage1);
        System.out.println(beverage1.getDescription() + " cost $" + beverage1.cost());
    }
}