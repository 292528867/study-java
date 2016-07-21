package com.yk.example.utils;

import com.yk.example.dto.Employee;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * Created by yukui on 2016/7/21.
 */
public class ReflectTest {

    public static void main(String[] args) {
        Class<Employee> employeeClass = Employee.class;
        Field[] declaredFields = employeeClass.getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {//获取所有的成员变量包括私有的
//            System.out.println(declaredFields[i]);
        }
        for (Field field : employeeClass.getFields()) {//获取共有的成员变量
//            System.out.println(field);
        }

        Employee employee = new Employee(new Date(),"test",1.2);
        try {
            Field nameField = employeeClass.getDeclaredField("name");
            nameField.setAccessible(true);
            String nameValue = (String) nameField.get(employee);
            System.out.println(nameValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
