package com.yk.example.designerPattern.factoryPattern.other;

import com.yk.example.designerPattern.factoryPattern.simple.CheesePizza;
import com.yk.example.designerPattern.factoryPattern.simple.ClamPizza;
import com.yk.example.designerPattern.factoryPattern.simple.GreekPizza;
import com.yk.example.designerPattern.factoryPattern.simple.Pizza;

/**
 * Created by yukui on 2016/7/18.
 */
public class NYPizzaStore extends PizzaStore {

    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if (("cheese").equals(type)) {
            pizza = new NYStyleCheesePizza();
        } else if (("greek").equals(type)) {
            pizza = new GreekPizza();
        } else if (("clam").equals(type)) {
            pizza = new ClamPizza();
        }
        return pizza;
    }
}
