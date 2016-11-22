package com.yk.example.java8;

import java.util.*;
import java.util.function.Predicate;

/**
 * Created by yukui on 2016/11/21.
 */
public class LambdaExample {

    static int outerStaticNum;
    int outerNum;

    public void compare() {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        //java8 之前
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        //java 8
        Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });
        //更加简洁的写法 java编译器能自动识别参数的类型
        Collections.sort(names, (a, b) -> b.compareTo(a));
    }


    public void testConverter() {
      /*  Converter<String, Integer> converter = new Converter<String, Integer>() {
            @Override
            public Integer converter(String from) {
                return Integer.valueOf(from);
            }
        };*/
        Converter<String, Integer> converter = from -> Integer.valueOf(from);

        //与匿名对象不同的是num可以不为final  num在编译的时候被隐式的当做final变量处理
        int num = 1;
        Converter<String, Integer> converter1 = from -> Integer.valueOf(from + num);

        //静态方法引用（java8允许::获取方法或者构造函数的引用）
        Converter<String, Integer> converter2 = Integer::valueOf;
        //构造函数的引用
        PersonFactory<Person> factory = Person::new;
        factory.create("yu", "kui", 12);
    }

    /**
     * 访问成员变量和静态变量
     */
    public void testScopes() {
        Converter<Integer, String> converter = from -> {
            outerNum = 23;
            return String.valueOf(from);
        };
        Converter<Integer, String> converter1 = from -> {
            outerStaticNum = 27;
            return String.valueOf(from);
        };
    }

    /**
     * 布尔类型函数
     */
    public void testPredicate() {
        Predicate<String> predicate = s -> s.length() > 0;
        predicate.test("foo");          //true
        predicate.negate().test("foo"); //false

        Predicate<Boolean> nonnull = Objects::nonNull;
        Predicate<Boolean> isnull = Objects::isNull;

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();
    }




}
