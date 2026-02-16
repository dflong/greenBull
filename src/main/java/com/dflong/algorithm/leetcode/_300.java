package com.dflong.algorithm.leetcode;

import java.util.Arrays;

public class _300 {

    public int lengthOfLIS(int[] nums) {
        // i位置的最长递增子序列
        int[] dp = new int[nums.length];

        // dp[i] = max(dp[i], dp[j] + 1)

        // 初始化
        Arrays.fill(dp, 1);

        int res = 0;
        // 遍历顺序
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
