package com.dflong.greenbull.leetcode;

import java.util.Arrays;

public class _674 {

    public int findLengthOfLCIS(int[] nums) {
        // i位置的最长连续递增序列
        int[] dp = new int[nums.length];

        //  dp[i] = dp[i - 1] + 1

        // 初始化
        Arrays.fill(dp, 1);

        int res = 1;
        // 遍历顺序
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }
}
