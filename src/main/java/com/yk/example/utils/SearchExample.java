package com.yk.example.utils;

/**
 * 查找例子
 * Created by yukui on 2016/9/7.
 */
public class SearchExample {

    public static int[] lineData={17,25,26,27,28,30,31,32,40,44,91,93,95};
    public static int counter = 1;//查找次数计数变量

    /**
     * 顺序查找(线性表)
     * @param key
     * @return
     */
    public static boolean linearSearch(int key) {
        for (int i=0;i<lineData.length;i++) {
            if (key == lineData[i]) {
                return true;
            }
            counter++;
        }
        return false;
    }

    /**
     * 二分查找（顺序存储的）
     * @param key
     * @return
     */
    public static boolean binarySearch(int key){
        int left = 0; //左边界变量
        int right = lineData.length - 1; //右边界变量
        int middle = 0;
        while (left < right) {
            middle = (left + right) / 2;
            if (key < lineData[middle]) { //与查找值较小
                right = middle - 1; //查找前半段
            } else if (key > lineData[middle]) {//与查找值大
                left = middle + 1;  //查找后半段
            } else if (key == lineData[middle]) {
                return true;
            }
            counter++;
        }
        return false;
    }


}
