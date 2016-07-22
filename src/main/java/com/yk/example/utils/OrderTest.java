package com.yk.example.utils;

/**
 * 2个有序数组合并后排序
 * Created by yk on 16/5/11.
 */
public final class OrderTest {

    public static void main(String[] args) {
        int a[] = {1, 3, 5, 7};
        int b[] = {2, 3, 4, 8, 9};
        int m[] = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
//            System.out.println(a[i++]);
//            System.out.println(b[j++]);
            if (a[i] <= b[j]) {
                m[k++] = a[i++];
            } else {
                m[k++] = b[j++];
            }
        }
        /* 后面连个while循环是用来保证两个数组比较完之后剩下的一个数组里的元素能顺利传入 */
        while (i < a.length)
            m[k++] = a[i++];
        while (j < b.length)
            m[k++] = b[j++];

//        System.out.println(m.length);
        for (int n = 0; n < m.length; n++) {
//            System.out.println(m[n]);
        }
    }


}
