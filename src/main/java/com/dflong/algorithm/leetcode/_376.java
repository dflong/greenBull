package com.dflong.algorithm.leetcode;

public class _376 {

    // 求的是子序列，不要求连续
    public int wiggleMaxLength(int[] nums) {
        int pre = 0, cur = 0, res = 0;
        for (int i = 1; i < nums.length; i++) {
            cur = nums[i] - nums[i - 1];
            if ((pre >= 0 && cur < 0) || (pre <= 0 && cur > 0)) {
                pre = cur;
                res ++;
            }
        }
        return res;
    }
}
