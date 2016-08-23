package com.yk.example.utils;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * hashMap非现成安全的 以通过Collections类的静态方法synchronizedMap获得线程安全的HashMap。
 * Created by yk on 16/3/22.
 */
public class HashMapExample {

    //    public static final Map<String,String> map = new HashMap();
    public static final Map<String, String> map = new Hashtable<String, String>();
//    public static final Map<String, String> map = Collections.synchronizedMap(new HashMap<String, String>());

    /**
     * 非线程安全
     *
     * @throws Exception
     */
    public static void testIsTreadSecurity() throws Exception {
        Thread t1 = new Thread() {
            public void run() {
                for (int i = 0; i < 200; i++) {
                    map.put(String.valueOf(i), String.valueOf(i));
                }
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                for (int j = 200; j < 400; j++) {
                    map.put(String.valueOf(j), String.valueOf(j));
                }
            }
        };

        t1.start();
        t2.start();

        //主线程休眠1秒钟，以便t1和t2两个线程将firstHashMap填装完毕。
        Thread.currentThread().sleep(1000);

        for (int i = 0; i < 400; i++) {
            if (!String.valueOf(i).equals(map.get(String.valueOf(i)))) {
                System.out.println(String.valueOf(i) + ":====" + map.get(String.valueOf(i)));
            }
        }
    }

    /**
     * 与hashtable的区别
     * 除了不同步(hashtable线程安全)和允许使用 null 之外，HashMap 类与 Hashtable 大致相同
     */
    public static void compareToHashTable() {
        Map map1 = new HashMap();
        Map map2 = new Hashtable();
        map1.put(null, null);
        try {
            map2.put(null, null);
        } catch (Exception e) {
            System.out.println("hashtable的健值对不能为null");
        }
    }

   /* public static void main(String[] args) throws Exception {
//        HashMapExample.testIsTreadSecurity();
//          HashMapExample.compareToHashTable();
        System.out.println(2.0-1.1);
        BigDecimal bd = new BigDecimal(2.0-1.1);
        System.out.println(bd.floatValue());
        System.out.println(2.0/0);
    }*/
}
