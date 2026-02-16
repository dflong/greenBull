package com.dflong.algorithm.leetcode;

public class _198 {

    public int rob(int[] nums) {
        // n位置最高金额
        int[] dp = new int[nums.length];

        // 递推公式 dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])

        // 初始化
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        // 遍历顺序
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[nums.length - 1];
    }
}
