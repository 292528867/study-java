package com.yk.example.designerPattern.factoryPattern.simple;

/**
 * Created by yukui on 2016/7/18.
 */
public class SimplePizzaFactory {

    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if (("cheese").equals(type)) {
            pizza = new CheesePizza();
        } else if (("greek").equals(type)) {
            pizza = new GreekPizza();
        } else if (("clam").equals(type)) {
            pizza = new ClamPizza();
        }
        return pizza;
    }
}
