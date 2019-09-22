package com.ngsky.walker.algorithm.sorts;

import java.util.Random;

/**
 * @Description: 选择排序
 * @Author: sunyx
 * @CreateDate: 2019/8/28 12:43
 */
public class SelectSort {

    void selectSort(int[] a) {
        if(a.length == 0) return;
        for (int i = 0; i < a.length; i++) {
            int min = a[i];
            int k = -1;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < min) {
                    min = a[j];
                    k = j;
                }
            }
            if (k != -1) {
                int tmp = a[i];
                a[i] = a[k];
                a[k] = tmp;
            }
        }
    }

    // test
    public static void main(String[] args) {
        int n = 100;
        int[] a = new int[n];
        Random r = new Random();
        // 生成随机测试数据
        for (int i = 0; i < n; i++) {
            a[i] = r.nextInt(10000);
        }
        System.out.println("规模n:" + n);
        SelectSort ss = new SelectSort();
        ss.selectSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
