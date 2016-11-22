package com.yk.example.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by yukui on 2016/11/22.
 */
public class FlatMapExample {
    private static List<Foo> foos = new ArrayList<>();

    static {
        //create foo
        IntStream.range(1, 4)
                .forEach(i -> foos.add(new Foo("Foo" + i)));

        //create bar
        foos.forEach(foo ->
                IntStream.range(1, 4)
                        .forEach(i -> foo.bars.add(new Bar("Bar" + i + "<- " + foo.name))));
    }

    public static void test() {
        foos.stream()
                .flatMap(foo -> foo.bars.stream())
                .forEach(bar -> System.out.println(bar.name));
    }
}
