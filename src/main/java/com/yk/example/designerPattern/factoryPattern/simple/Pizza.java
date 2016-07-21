package com.yk.example.designerPattern.factoryPattern.simple;

/**
 * Created by yukui on 2016/7/18.
 */
public abstract class Pizza {

    private SimplePizzaFactory factory;

    public Pizza orderPizza(String type){
        Pizza pizza = factory.createPizza(type) ;
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    public abstract void prepare();

    public abstract void bake();

    public abstract void cut();

    public abstract void box();

    public SimplePizzaFactory getFactory() {
        return factory;
    }

    public void setFactory(SimplePizzaFactory factory) {
        this.factory = factory;
    }
}
