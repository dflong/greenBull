package com.dflong.algorithm.leetcode;

public class _213 {

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
    }

    public int rob(int[] nums, int l, int r) {
        // n位置最高金额
        int[] dp = new int[r - l + 1];

        // 递推公式 dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])

        // 初始化
        dp[l] = nums[l];
        dp[l + 1] = Math.max(nums[l], nums[l + 1]);

        // 遍历顺序
        for (int i = l + 2; i < r; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[r - 1];
    }
}
