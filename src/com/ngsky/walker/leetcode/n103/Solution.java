package com.ngsky.walker.leetcode.n103;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * <dl>
 * <dt>Solution</dt>
 * <dd>Description:</dd>
 * <dd>CreateDate: 2019/10/13 下午1:51</dd>
 * </dl>
 *
 * @author ngsky
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        level(root, 0, res);
        return res;
    }


    Queue<TreeNode> queue;

    private void level(TreeNode root, int level,List<List<Integer>> res){
        if(root==null) return;
        TreeNode ct = queue.poll();

        if(res.size()==level){
            List<Integer> a = new ArrayList<>();
            a.add(root.val);
            res.add(a);
        } else {
            res.get(level).add(root.val);
        }
        if(level%2==0){
            level(root.right,level+1,res);
            level(root.left,level+1,res);
        } else {
            level(root.left,level+1,res);
            level(root.right,level+1,res);
        }
    }
}

class Test{
    public static void main(String[] args) {
        TreeNode t4=new TreeNode(15);
        TreeNode t5=new TreeNode(7);
        TreeNode t3=new TreeNode(20);
        t3.left=t4;t3.right=t5;
        TreeNode t2=new TreeNode(9);
        TreeNode t1=new TreeNode(3);
        t1.left=t2;t1.right=t3;

        Solution so = new Solution();
        System.out.println(so.zigzagLevelOrder(t1));
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
