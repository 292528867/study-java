package com.yk.example.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by yukui on 2016/11/22.
 */
public class CollectStreamExample {

    private static List<Person> persons = new ArrayList<>();

    static {
        persons = Arrays.asList(
                new Person("Max", 18),
                new Person("Peter", 23),
                new Person("Pamela", 23),
                new Person("David", 30)
        );
    }

    public static void testCollect() {
        List<Person> list = persons.stream()
                .filter(person -> person.toString().startsWith("P"))
                .collect(Collectors.toList());
        System.out.println(list);
    }

    /**
     * 年龄分组
     */
    public static void testGroupBy() {
        Map<Integer, List<Person>> personByAge = persons.stream()
                .collect(Collectors.groupingBy(p -> p.getAge()));

        personByAge.forEach((age,p)->{
            System.out.format("age %s : %s \n", age, p);
        });
    }

    /**
     * 计算平均年龄
     */
    public static  void testAveraging(){
        Double averge = persons.stream()
                .collect(Collectors.averagingInt(p -> p.getAge()));
        System.out.println(averge);
    }


}
