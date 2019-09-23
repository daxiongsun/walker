package com.ngsky.walker.codeforces.p1221;

import java.util.Scanner;

/**
 * <dl>
 * <dt>A2048Game</dt>
 * <dd>Description:</dd>
 * <dd>CreateDate: 2019/9/22 下午10:22</dd>
 * </dl>
 *
 * 解题思路：如果输入中某个数字只有单个，那该数字其实就是无效数字，
 * 将输入数字叠加，如果sum >= 2048，那就可以合并，否则，不能进行合并。
 * 合并条件： 1 -> 2 -> 4 -> 8 -> 16 -> 32 -> 64 -> 128 -> 256 -> 512 -> 1024 -> 2048
 * 例如：单数情况：1 + 2 + 4 + ... + 1024 = 2047， 也都比 2048 小，所以必须满足某些数字存在
 * 多个，然后进行累加和 >= 2048
 *
 * @author ngsky
 */
public class A2048Game {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                if(x <= 2048) sum+=x;
            }
            if(sum >= 2048) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
