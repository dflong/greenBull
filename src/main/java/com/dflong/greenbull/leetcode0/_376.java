package com.dflong.greenbull.leetcode0;

public class _376 {

    public int wiggleMaxLength(int[] nums) {
        int n = nums.length, res = 1;
        int pre = 0, cur = 0; // 前一个、当前差值
        for (int i = 1; i < n; i++) {
            cur = nums[i] - nums[i - 1];
            if ((pre >= 0 && cur < 0) || (pre <= 0 && cur > 0)) {
                pre = cur;
                res ++;
            }
        }
        return res;
    }
}
