package com.ngsky.walker.algorithm.dfs;

import java.util.Scanner;

/**
 * <dl>
 * <dt>Q1</dt>
 * <dd>Description:</dd>
 * <dd>CreateDate: 2019/10/13 下午6:12</dd>
 * </dl>
 *
 * 给定整数 a1,a2,a3...an,判断是否可以从中选出若干数，使它们的和为K
 *
 * constrains:
 * 1. 1<=n<=20
 * 2. -10^8<=ai<=10^8
 * 3. -10^8<=k<=10^8
 *
 * input:
 * 4
 * 1,2,4,7
 * 15
 *
 * first line: n
 * second line: a0,a1...an
 * third line: k
 *
 * output:
 * Yes/No
 *
 * @author ngsky
 */
public class Q1 {

    static final int MAXN=20;
    static int[] a=new int[MAXN];
    static int n,k;
    // 已经从前i项得到了和sum，然后对于i项之后的进行分支
    static boolean dfs(int i,int sum){
        if(i==n) return sum==k;
        // 不加a[i]的情况
        if(dfs(i+1,sum)) return true;
        // 加a[i]的情况
        if(dfs(i+1,sum+a[i])) return true;
        // 无论是否加上a[i]都不能凑成k就返回false
        return false;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        for (int i = 0; i < n; i++) {
            a[i]=sc.nextInt();
        }
        k=sc.nextInt();

        if(dfs(0,0)) System.out.println("Yes");
        else System.out.println("No");
    }
}
