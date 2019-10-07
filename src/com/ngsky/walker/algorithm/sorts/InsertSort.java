package com.ngsky.walker.algorithm.sorts;

import java.util.Random;

/**
 * @Description: 插入排序
 *      摸牌->找点->后移->插入
 * @Author: sunyx
 * @CreateDate: 2019/8/29 12:06
 */
public class InsertSort {

    /**
     * version 1.0
     * 直接插入:摸牌->找点->后移->插入
     */
    void insertSort(int[] a){
        if(a.length <= 1) return;
        for (int i = 1; i < a.length; i++) {
            int index = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (a[i] < a[j] && (j - 1 <= -1 || a[i] >= a[j - 1])) {
                    index = j;
                    break;
                }
            }
            if (index != -1) {
                int tmp = a[i];
                for (int k = i; k > index; k--) {
                    a[k] = a[k - 1];
                }
                a[index] = tmp;
            }
        }
    }

    /**
     * version2.0: 优化
     * 合并 找点+后移[不可行]
     */
//    void insertSort2(int[] a){
//        if(a.length <= 1)return ;
//        for (int i = 1; i < a.length; i++) {
//            int tmp = a[i];
//            for (int j = i - 1; j >= 0; j--) {
//                if (j - 1 <= -1) {
//                    a[i] = a[j];
//                    a[j] = tmp;
//                } else if (a[i] >= a[j - 1]) {
//                    a[j] = tmp;
//                } else if (a[i] < a[j]) {
//                    a[j] = a[i];
//                }
//            }
//        }
//    }

    /**
     * version3.0 二分法优化
     *
     */
    void insertSort3(int[] a){

    }

    public static void main(String[] args) {
        int n = 10;
        int[] a = new int[n];
        Random r = new Random();
        // 生成随机测试数据
        for (int i = 0; i < n; i++) {
            a[i] = r.nextInt(10);
            System.out.print(a[i] + ",");
        }
        System.out.println();

        a = new int[]{
                1,0,7,7,0,6,5,6,3,9,
        };

        System.out.println("规模n:" + n);
        InsertSort is = new InsertSort();
//        is.insertSort(a);
        is.insertSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
        }
    }
}
