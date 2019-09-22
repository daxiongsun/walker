package com.ngsky.walker.algorithm.kmp;

/**
 * <dl>
 * <dt>KMPSimple</dt>
 * <dd>Description: KMP 算法简化版: 给定两个字符串A，B，求A串是否包含B串，如果是则输出首次匹配时，B在A中的索引，否则输出-1</dd>
 * <dd>CreateDate: 2019/9/22 上午4:09</dd>
 * </dl>
 *
 * @author ngsky
 */
public class KMPSimple {
    public int solution(String A, String B){

    }

    public static void main(String[] args){
        KMPSimple s = new KMPSimple();

        String A = "aabaaab";
        String B = "aaa";

        System.out.println(s.solution(A, B));
    }
}
