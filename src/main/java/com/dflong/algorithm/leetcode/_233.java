package com.dflong.algorithm.leetcode;

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
    }
    private List<Integer> list = new ArrayList<>();
    private void traversal(char[] s, int idx, int path, boolean isLimit) {
        // 结束条件
        if (idx == s.length) {
            list.add(path);
            return ;
        }
        // 确定选择的上界
        // 如果 isLimit 为 true，那么可选择的上界不能超过该位的值；否则可以一直选择到 9
        int up = isLimit ? s[idx] - '0' : 9;
        for (int d = 0; d <= up; d++) {
            // 递归遍历下一位
            // 下一位的 isLimit 确定方法：当前位被限制了，而且选择的值是上界
            // 继续按照上图，举个例子：当处于第 0 位时，isLimit 为 true，
            // 如果此时选择上界 1，那么遍历第 1 位的时候也是被限制的；
            // 但是如果此时选择的不是上界 1，那么遍历第 1 位的时候就没有被限制
            traversal(s, idx + 1, path * 10 + d, isLimit && d == up);
        }
    }

}
