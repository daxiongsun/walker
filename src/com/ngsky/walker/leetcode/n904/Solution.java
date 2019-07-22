package com.ngsky.walker.leetcode.n904;

/**
 * <dl>
 * <dt>Solution</dt>
 * <dd>Description:</dd>
 * <dd>CreateDate: 19-7-23 上午12:47</dd>
 * </dl>
 *
 * 在一排树(tree)集合中，第 i 棵树的类型为 tree[i]
 * 你可以随意选择从任何一棵树开始，然后执行以下两个步骤:
 * 1.将这棵树的上的水果添加到果篮中，如果不想添加，则可停止。
 * 2.移动到当前树的右边树上，如果右边没有树，则停止。
 *
 * 注意：初始化选择树的位置后不能改变且必须按照顺序执行 第一步，第二步，第一步，第二步 ...,直到停止
 *      你有两个果篮，每个果蓝可以放不同类型的水果，但是你仅仅想让每个果蓝只放一种类型的水果。
 *
 * 问题：按照这种生产方式，挑选水果的最大数量是多少？
 *
 *
 * @author ngsky
 */
public class Solution {

    int A, B, maxTotal, end, lastV = -1;

    public int totalFruit(int[] tree) {
        A = B = maxTotal = end = 0;
        lastV = -1;
        count(0, tree);
        return maxTotal;
    }

    void count(int index, int[] tree) {
        if (index >= tree.length) {
            return;
        }
        A = tree[index];
        int total = 1;
        B = 40001;
        if (A == lastV) {
            maxTotal = total > maxTotal ? total : maxTotal;
            count(index + 1, tree);
        }
        lastV = A;
        for (int i = index + 1; end < tree.length - 1 && i < tree.length; i++) {
            end = i;
            if (tree[i] == A || tree[i] == B) {
                total++;
            } else if (B == 40001) {
                B = tree[i];
                total++;
            } else {
                maxTotal = total > maxTotal ? total : maxTotal;
                count(index + 1, tree);
            }
        }
        maxTotal = total > maxTotal ? total : maxTotal;
    }

    public static void main(String[] args) {
        Solution so = new Solution();

        int[] tree = new int[]{1, 2, 1};

        System.out.println(so.totalFruit(tree));

        tree = new int[]{0, 1, 2, 2};
        System.out.println(so.totalFruit(tree));

        tree = new int[]{1, 2, 3, 2, 2};
        System.out.println(so.totalFruit(tree));

        tree = new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        System.out.println(so.totalFruit(tree));

        tree = new int[]{0};
        System.out.println(so.totalFruit(tree));

        tree = new int[]{39999,3999,39999,3999,39999,3999,39999,3999,39999,3999,39999,3999,39999,3999,39999,3999,39999,3999,39999,3999,39999,3999,39999,3999,39999,3999};
        System.out.println(so.totalFruit(tree));

        tree = new int[]{39999, 3999, 39999, 3999, 39999, 3999, 39999, 3999, 39999, 3999, 39999, 3999, 39999, 3999, 39999, 3999, 39999, 3999, 39999, 3999, 39999, 3999, 39999, 3999, 39999, 0};
        System.out.println(so.totalFruit(tree));

        tree = new int[]{39999, 39999, 39999, 39999, 39999, 39999, 39999, 39999, 39999, 39999, 39999, 39999, 39999, 39999, 39999, 39999, 39999, 39999, 39999, 39999, 39999, 39999, 39999, 39999, 39999, 39999};
        System.out.println(so.totalFruit(tree));

        tree = new int[]{39999, 39999, 39999, 39999, 39999, 39999, 39999, 39999, 39999, 39999, 39999, 39999, 39999, 39999, 39999, 39999, 39999, 39999, 39999, 39999, 39999, 39999, 39999, 39999, 39999, 0};
        System.out.println(so.totalFruit(tree));

        tree = new int[]{39999, 39999, 39999, 39999, 39999, 39999, 39999, 39999, 39999, 39999, 39999, 39999, 39999, 39999, 39999, 39999, 39999, 39999, 0, 39999, 39999, 39999, 39999, 39999, 39999, 0};
        System.out.println(so.totalFruit(tree));
    }
}
