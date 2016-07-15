package com.yk.example.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by yk on 16/5/27.
 */
public class ListTest {

    public static void main(String[] args) {
        testListIterator();
        testPerBtwnArlAndLkl();
    }

    /**
     * list那个remove回抛异常是因为快速失败的机制，
     * 他内置了一个modifyCount的变量记录list的长度变化，用Iter可以删除掉
     * ListIterator 的使用
     */
    public static void testListIterator() {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("aaa");
        list.add("bbb");
        list.add("3");
        list.add("4");

       /* for (String s : list) {
            if (s.length() > 1) {
                list.remove(s);
            }
        }*/

      /*  ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            String s = String.valueOf(listIterator.next());
            if (s.length() > 1) {
                listIterator.remove();
            }
        }*/
        for (ListIterator listIterator = list.listIterator(); listIterator.hasNext(); ) {
            String s = String.valueOf(listIterator.next());
            if (s.length() > 1) listIterator.remove();
        }
        StringBuilder sb = new StringBuilder();
        System.out.println(sb.append(" ").toString().length() == 0);
        System.out.println(sb.toString().length() == 0);
        System.out.println(StringUtils.isNotEmpty(sb.toString()));
        System.out.println(StringUtils.isNotBlank(sb.toString()));
        System.out.println(list.size());
    }

    /**
     * ArrayList与LinkedList各方法性能的对比
     */
    public static void testPerBtwnArlAndLkl() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        // ArrayList add方法
        long startTime = System.nanoTime();
        long endTime;
        long duration;
        for (int i = 0; i < 100000; i++)
            arrayList.add(i);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("ArrayList add:  " + duration);

        // LinkedList add方法
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++)
            linkedList.add(i);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("LinkedList add: " + duration);

        // ArrayList get方法
        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++)
            arrayList.get(i);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("ArrayList get:  " + duration);

        // LinkedList get方法
        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++)
            linkedList.get(i);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("LinkedList get: " + duration);

        // ArrayList remove方法
        startTime = System.nanoTime();
        for (int i = 9999; i >= 0; i--)
            arrayList.remove(i);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("ArrayList remove:  " + duration);

        // LinkedList remove方法
        startTime = System.nanoTime();
        for (int i = 9999; i >= 0; i--)
            linkedList.remove(i);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("LinkedList remove: " + duration);
    }
}
