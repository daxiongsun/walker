package com.ngsky.walker.leetcode.n903;

/**
 * @Description:
 * @Author: sunyx@lenovocloud.com
 * @CreateDate: 2019/7/24 12:43
 *
 * 题意：给定一个 S 序列，有 D 和 I 两个元素组成.D：表示递减, P[i] > P[i+1]; I:表示递增,P[i] < P[i+1]. S 元素个数为 n.
 *      P 表示有 [0 ~ S.size()] 组成的排列组合.P[0],P[1],P[2]...P[n]
 *
 * 求解：计算满足序列S要求的 所有排序组合数量.
 *
 *
 */
public class Solution {
    /**
     * 第一种
     * 41 ms	36.3 MB	java
     */
    public int numPermsDISequence(String S) {
        int n = S.length();
        int[][] dp = new int[n + 1][n + 1];
        int M = 1000000007;
        int ret = 0;

        dp[0][0] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j <= i; ++j) {
                char C = S.charAt(i - 1);
                if (C == 'D') {
                    for (int k = j; k <= i - 1; ++k) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][k]) % M;
                    }
                } else {
                    for (int k = 0; k <= j - 1; ++k) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][k]) % M;
                    }
                }
            }
        }
        for (int i = 0; i <= n; ++i) {
            ret = (ret + dp[n][i]) % M;
        }
        return ret;
    }

    /**
     * 第二种方法[推荐]
     * Accepted	3 ms	35.5 MB	java
     */
    public int numPermsDISequence_2(String S) {
        int n = S.length();
        int[][] dp = new int[n + 1][n + 1];
        int M = 1000000007;

        for (int j = 0; j <= n; ++j) dp[0][j] = 1;
        for (int i = 0; i < n; ++i) {
            char C = S.charAt(i);
            if (C == 'I') {
                for (int j = 0, cur = 0; j < n - i; ++j) {
                    dp[i + 1][j] = cur = (cur + dp[i][j]) % M;
                }
            } else {
                for (int j = n - 1 - i, cur = 0; j >= 0; --j) {
                    dp[i + 1][j] = cur = (cur + dp[i][j + 1]) % M;
                }
            }
        }
        return dp[n][0];
    }

    public static void main(String[] args) {
        Solution so = new Solution();
//        System.out.println("ret:" + so.numPermsDISequence("DIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIIIIIIIIDDDDD"));
//        System.out.println("ret:" + so.numPermsDISequence("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD"));
//        System.out.println("ret:" + so.numPermsDISequence("IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII"));
//        System.out.println("ret:" + so.numPermsDISequence("I"));
//        System.out.println("ret:" + so.numPermsDISequence("D"));

        System.out.println("ret:" + so.numPermsDISequence_2("DIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIIIIIIIIDDDDD"));
    }
}
