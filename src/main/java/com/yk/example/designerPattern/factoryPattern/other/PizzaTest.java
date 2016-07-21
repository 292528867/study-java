package com.yk.example.designerPattern.factoryPattern.other;

/**
 * Created by yukui on 2016/7/18.
 */
public class PizzaTest {

    public static void main(String[] args) {
        NYPizzaStore nyPizzaStore = new NYPizzaStore();
        nyPizzaStore.orderPizza("chesse");
    }

}
