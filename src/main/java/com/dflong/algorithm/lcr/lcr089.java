package com.dflong.algorithm.lcr;

public class lcr089 {

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length]; // i位置的最大值
        // dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        dp[0] = nums[0]; // 初始化
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i ++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[nums.length - 1];
    }
}
