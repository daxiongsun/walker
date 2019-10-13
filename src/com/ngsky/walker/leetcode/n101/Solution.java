package com.ngsky.walker.leetcode.n101;

/**
 * <dl>
 * <dt>Solution</dt>
 * <dd>Description:</dd>
 * <dd>CreateDate: 2019/10/13 上午9:15</dd>
 * </dl>
 *
 * @author ngsky
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return isSame(root.right,root.left);
    }
    public boolean isSame(TreeNode p, TreeNode q){
        if(p==null&&q==null) return true;
        if(p==null||q==null||p.val!=q.val) return false;
        return isSame(p.right,q.left) && isSame(p.left,q.right);
    }
}

class Test{
    public static void main(String[] args) {

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
