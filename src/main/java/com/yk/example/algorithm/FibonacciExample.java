package com.yk.example.algorithm;

/**
 * 斐波那契数列 (F0 = 0 ,F1=1, Fn=Fn-1+Fn-2)
 * Created by yukui on 2016/9/7.
 */
public class FibonacciExample {

    // 关联矩阵
    private static final int[][] UNIT = { { 1, 1 }, { 1, 0 } };
    // 全0矩阵
    private static final int[][] ZERO = { { 0, 0 }, { 0, 0 } };

    /**
     * 2层递归
     *
     * @param n
     * @return
     */
    public static long fibonacci1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci1(n - 1) + fibonacci1(n - 2);
    }


    /**
     *  递推
     *
     * @param n
     * @return
     */
    public static long fibonacci3(int n) {
        long result = 0, firstItem = 0, secondItem = 1;
        int cnt = 1;
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            while (cnt < n) {
                result = firstItem + secondItem;
                firstItem = secondItem;
                secondItem = result;
                cnt++;
            }
            return result;
        }
    }

    /**
     * 矩阵(线性代数矩阵连乘公式 二分法)
     * @param n
     * @return
     */
    public static long fibonacci4(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
           return matrixPower(n-1)[0][0];
        }
    }


    /**
     * 矩阵幂运算
     * @param n
     * @return
     */
    public static int[][] matrixPower(int n){
        if (n == 0) {
            return ZERO;
        }
        if (n == 1) {
            return UNIT;
        }
        if ((n & 1) == 0) {//奇数
            int[][] matrix = matrixPower(n >> 1);
            return matrixMutiple(matrix, matrix);
        }
        //偶数
        int[][] matrix = matrixPower((n - 1) >> 1);
        return matrixMutiple(matrixMutiple(matrix, matrix), UNIT);
    }

    /**
     * 两矩阵相乘
     * @param matrix1
     * @param matrix2
     * @return
     */
    public static int[][] matrixMutiple(int[][] matrix1,int[][] matrix2) {
        int[][] result = new int[matrix1.length][matrix2[0].length];
        for(int i=0;i<matrix1.length;i++) {
            for(int j=0;j<matrix2[i].length;j++) {
                int temp = 0;
                for(int k=0;k<matrix1[0].length;k++) {
                    temp = matrix1[i][k] * matrix2[k][j] + temp;
                }
                result[i][j] = temp;
            }
        }
        return result;
    }
}
