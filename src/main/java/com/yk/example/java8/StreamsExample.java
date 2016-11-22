package com.yk.example.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by yukui on 2016/11/21.
 */
public class StreamsExample {

    private static List<String> stringCollection = new ArrayList<>();

    static {
        stringCollection.add("aaa1");
        stringCollection.add("aaa2");
        stringCollection.add("aaa3");
        stringCollection.add("bbb1");
        stringCollection.add("bbb2");
        stringCollection.add("bbb3");
        stringCollection.add("ccc1");
        stringCollection.add("ccc2");
        stringCollection.add("ddd1");
        stringCollection.add("ddd2");
    }

    /**
     * filter接受一个predicate接口类型的变量，并将所有流对象中的元素进行过滤
     */
    public static void testFilter() {
        stringCollection.stream()
                .filter(s -> s.startsWith("a"))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    /**
     * Sorted是一个中间操作，能够返回一个排过序的流对象的视图
     * 一定要记住,sorted只是创建一个流对象排序的视图，而不会改变原来集合中元素的顺序
     */
    public static void testSorted() {
        stringCollection.stream()
                .sorted()
                .filter(s -> s.startsWith("a"))
                .forEach(System.out::println);
    }

    /**
     *
     */
    public static void testMap() {
        stringCollection.stream()
                .map(String::toUpperCase)
                .sorted((a, b) -> b.compareTo(a))
                .forEach(System.out::println);
    }

    public static void testMatch() {
        boolean anyMatchStartA = stringCollection.stream()
                .anyMatch(s -> s.startsWith("a"));
        System.out.println(anyMatchStartA);  //true

        boolean allMatchStartA = stringCollection.stream()
                .allMatch(s -> s.startsWith("a"));
        System.out.println(allMatchStartA);  //false

        boolean noneMatchStartZ = stringCollection.stream()
                .noneMatch(s -> s.startsWith("z"));
        System.out.println(noneMatchStartZ); //true
    }

    public static void testCount() {
        long count = stringCollection.stream().filter(s -> s.startsWith("a")).count();
        System.out.println(count);
    }

    public static void testReduce() {
        Optional<String> reduce = stringCollection.stream()
                .sorted()
                .reduce((s1, s2) -> s1 + "#" + s2);
        reduce.ifPresent(System.out::println);
    }

    /**
     * 流并行操作(多线程执行) parallelStream比stream快一半
     */
    public static void testParallel() {
        int max = 1000000;
        List<String> values = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }

        long t0 = System.nanoTime();
        long count = values.parallelStream().sorted().count();
        System.out.println(count);
        long t1 = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(millis);
    }

    /**
     * 衔接操作的延迟性
     * 没加forEach时filter中不会打印出来 衔接操作只在终止操作调用时执行
     */
    public static void test() {
      /*  Stream.of("d2", "a2", "b1", "c3", "a3")
                .filter(s -> {
                    System.out.println("filter:" + s);
                    return true;
                })
                .forEach(s -> System.out.println("forEach:" + s));*/

        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter:" + s);
                    return s.startsWith("a");
                })
                .sorted((s1, s2) -> {
                    System.out.printf("sort : %s; %s\n", s1, s2);
                    return s1.compareTo(s2);
                })
                .map(s -> {
                    System.out.println("map:" + s);
                    return s.toUpperCase();
                })
                .forEach(s -> {
                    System.out.println("forEach:" + s);
                });

    }

}
