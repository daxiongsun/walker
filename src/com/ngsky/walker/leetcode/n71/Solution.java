package com.ngsky.walker.leetcode.n71;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * <dl>
 * <dt>Solution</dt>
 * <dd>Description:</dd>
 * <dd>CreateDate: 2019/9/23 下午9:37</dd>
 * </dl>
 *
 * @author ngsky
 */
public class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        //三种需要跳过的情况
        Set<String> skip = new HashSet<String>(Arrays.asList("..", ".", ""));

        for (String dir : path.split("/")) {
            //当遇到..时，需要向前进
            if (dir.equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else if (!skip.contains(dir)) {
                stack.push(dir);
            }
        }
        String result = "";
        if (stack.isEmpty()) result += "/";
        while (!stack.isEmpty()) {
            //pop出来的顺序是反的，所以加的时候，把最新pop出来的路径加在前面
            result = "/" + stack.pop() + result;
        }
        return result;
    }

//    public static void main(String[] args) {
//        Solution s = new Solution();
//        String input = "/home/";
////        input = "/x/..";
//        input = "/../";
//        input = "/home//foo/";
//        input = "/a/./b/../../c/";
//        input = "/a/../../b/../c//.//";
//        input = "/a//b////c/d//././/..";
//        input = "/xs/..y..sgc/y../fd";
//        System.out.println(s.simplifyPath(input));
//    }
}
