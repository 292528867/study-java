package com.yk.example.designerPattern.factoryPattern.other;

import com.yk.example.designerPattern.factoryPattern.simple.Pizza;
import com.yk.example.designerPattern.factoryPattern.simple.SimplePizzaFactory;

/**
 * Created by yukui on 2016/7/18.
 */
public class NYPizzaFactory extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        return null;
    }
}
