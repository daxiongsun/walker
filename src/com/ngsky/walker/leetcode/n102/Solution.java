package com.ngsky.walker.leetcode.n102;

import java.util.ArrayList;
import java.util.List;

/**
 * <dl>
 * <dt>Solution</dt>
 * <dd>Description:</dd>
 * <dd>CreateDate: 2019/10/13 上午11:04</dd>
 * </dl>
 *
 * @author ngsky
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        levelOrderRecursive(root, 0, res);
        return res;
    }
    /**
     * 理解递归的本质
     * 如下为：先序遍历
     * 1.levelOrderRecursive(root.left,level+1,res): 递归遍历左子树，直到节点为null后返回上一层级
     * 2.levelOrderRecursive(root.right,level+1,res): 当左子树遍历到null节点后，返回到上一层，此时会进行递归遍历右子树
     * 3.递归进行下一层时,level都需要加1，当遇到节点为null时，返回上一层，level又回到了上一层值(注意)
     * 4.当每一层都遍历完后，需要重新建立list子集
     */
    private void levelOrderRecursive(TreeNode root,int level,List<List<Integer>> res){
        if(root==null) return;
        if(res.size()==level){
            List<Integer> list = new ArrayList<Integer>();
            list.add(root.val);
            res.add(list);
        } else{
            res.get(level).add(root.val);
        }
        levelOrderRecursive(root.left,level+1,res);
        levelOrderRecursive(root.right,level+1,res);
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
        System.out.println(so.levelOrder(t1));
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

