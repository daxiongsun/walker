package com.ngsky.walker.algorithm.chapter4;

/**
 * <dl>
 * <dt>MaxSubArray</dt>
 * <dd>Description: 最大子数组问题 </dd>
 * <dd>CreateDate: 2019/8/26 下午9:25</dd>
 * </dl>
 * <p>
 * 1.左子数组:  left <= i <= j <= mid
 * 2.右子数组:  mid < i<= j <= right
 * 3.跨越中间点: left <= i <= mid < j <= right
 *
 * 时间复杂度：
 *
 *         | O(1)             ;n = 1
 * T(n) =  | 2T(n/2) + O(n)   ;n > 1
 *
 * @author ngsky
 */
public class MaxSubArray {

    /**
     * [0]: left_low
     * [1]: right_high
     * [2]: sum
     * 当子数组跨越中点mid时，计算最大子数组和
     */
    private int[] crossSubArray(int[] a, int left, int mid, int right) {
        int[] ret = new int[3];
        int left_sum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= left; i--) {
            sum += a[i];
            if (sum > left_sum) {
                left_sum = sum;
                ret[0] = i;
            }
        }
        int right_sum = Integer.MIN_VALUE;
        sum = 0;
        for (int i = mid + 1; i <= right; i++) {
            sum += a[i];
            if (sum > right_sum) {
                right_sum = sum;
                ret[1] = i;
            }
        }
        ret[2] = left_sum + right_sum;
        return ret;
    }

    private int[] maxSubArray(int[] a, int left, int right) {
        if (left == right) {
            int[] ret = new int[3];
            ret[0] = left;
            ret[1] = right;
            ret[2] = a[left];
            return ret;
        }
        int mid = (left + right) / 2;
        int[] lr = maxSubArray(a, left, mid);
        int[] rr = maxSubArray(a, mid + 1, right);
        int[] mr = crossSubArray(a, left, mid, right);
        if (lr[2] >= rr[2] && lr[2] >= mr[2]) return lr;
        if (rr[2] >= lr[2] && rr[2] >= mr[2]) return rr;
        return mr;
    }

    public static void main(String[] args) {
        MaxSubArray m = new MaxSubArray();
        int[] a = new int[]{
                13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7
        };
        int[] ret = m.maxSubArray(a, 0, a.length - 1);
        System.out.println(ret[0] + "," + ret[1] + "," + ret[2]);
    }
}
