package com.yk.example.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yukui on 2016/11/22.
 */
public class ReduceExample {

    private static List<Person> persons = new ArrayList<>();

    static {
        persons = Arrays.asList(
                new Person("Max", 18),
                new Person("Peter", 23),
                new Person("Pamela", 23),
                new Person("David", 30)
        );
    }

    /**
     * 计算出最老的人
     */
    public static void test() {
        persons.stream()
                .reduce((p1, p2) -> p1.getAge() > p2.getAge() ? p1 : p2)
                .ifPresent(System.out::println);
    }


}
