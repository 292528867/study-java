package com.yk.example.designerPattern.factoryPattern.other;

import com.yk.example.designerPattern.factoryPattern.simple.Pizza;

/**
 * Created by yukui on 2016/7/18.
 */
public class ChicagoPizzaFactory extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        return null;
    }
}
