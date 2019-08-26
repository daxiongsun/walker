package com.ngsky.walker.algorithm;

/**
 * @Description: 进制转换器
 * @Author: ngsky
 * @CreateDate: 2019/8/12 14:08
 */
public class HexConver {

    /**
     * 十进制 转化 为 K 进制
     */
    public static String tenK(int ten, int k) {
        if(ten == 0 || k == 0) return "0";
        return tenK(ten, k, "");
    }
    private static String tenK(int ten, int k, String res){
        if (ten == 0) {
            StringBuilder ret = new StringBuilder();
            for(int i = res.length() - 1; i >= 0;i--){
                ret.append(res.charAt(i));
            }
            return ret.toString();
        }
        return tenK(ten / k, k, res + (ten % k));
    }

}
