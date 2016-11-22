package com.yk.example.java8;

/**
 * Created by yukui on 2016/11/21.
 */
public interface PersonFactory <P extends Person>{
    Person create(String firstName,String lastName,int age);
}
