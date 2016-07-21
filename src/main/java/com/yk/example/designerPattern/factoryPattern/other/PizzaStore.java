package com.yk.example.designerPattern.factoryPattern.other;

import com.yk.example.designerPattern.factoryPattern.simple.Pizza;

/**
 * Created by yukui on 2016/7/18.
 */
public abstract class PizzaStore {



    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    //让子类决定如何做pizza，因此抽象出来
    protected abstract Pizza createPizza(String type);

}
