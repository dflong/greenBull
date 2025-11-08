package com.dflong.greenbull.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _233 {

    public static void main(String[] args) {
        new _233().countDigitOne(13);
    }

    // https://leetcode.cn/problems/numbers-at-most-n-given-digit-set/solutions/1900038/by-lfool-epqy/?envType=problem-list-v2&envId=bec5g5r
    public int countDigitOne(int n) {

        char[] s = Integer.toString(n).toCharArray();
        // 处于第 0 位的时候，选择是被限制的，只能选择不超过第 0 位的值
        traversal(s, 0, 0, true);
        return 9;

//        String s = Integer.toString(n);
//
//        if (s.length() == 1) return n > 0 ? 1 : 0;
//
//        // 按数位讨论
//        int[] prefix = new int[s.length()];
//        int[] suffix = new int[s.length()];
//
//        for (int i = 1; i < s.length() - 1; i ++) {
//            prefix[i] = Integer.parseInt(s.substring(0, i));
//            suffix[i] = Integer.parseInt(s.substring(i + 1));
//        }
//        suffix[0] = Integer.parseInt(s.substring(1));
//        prefix[s.length() - 1] = Integer.parseInt(s.substring(0, s.length() - 1));
//
//        int res = 0;
//        for (int i = 0; i < s.length(); i ++) {
//            int x = s.charAt(i) - '0';
//            int len = s.length() - i - 1;
//
//            int total = 0;
//            total += prefix[i] * Math.pow(10, len); // 前缀小于
//
//            // 前缀等于
//            if (x == 0) {
//                // 0
//            } else if (x == 1) {
//                total += suffix[i] + 1;
//            } else {
//                total += Math.pow(10, len);
//            }
//
//            res += total;
//        }
//
//        return res;
    }
    private List<Integer> list = new ArrayList<>();
    private void traversal(char[] s, int i, int path, boolean isLimit) {
        // 结束条件
        if (i == s.length) {
            list.add(path);
            return ;
        }
        // 确定选择的上界
        // 如果 isLimit 为 true，那么可选择的上界不能超过该位的值；否则可以一直选择到 9
        int up = isLimit ? s[i] - '0' : 9;
        for (int d = 0; d <= up; d++) {
            // 递归遍历下一位
            // 下一位的 isLimit 确定方法：当前位被限制了，而且选择的值是上界
            // 继续按照上图，举个例子：当处于第 0 位时，isLimit 为 true，
            // 如果此时选择上界 1，那么遍历第 1 位的时候也是被限制的；
            // 但是如果此时选择的不是上界 1，那么遍历第 1 位的时候就没有被限制
            traversal(s, i + 1, path * 10 + d, isLimit && d == up);
        }
    }

}
