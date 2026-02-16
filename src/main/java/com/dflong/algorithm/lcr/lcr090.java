package com.dflong.algorithm.lcr;

public class lcr090 {

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        return Math.max(rob1(nums, 0, nums.length - 1), rob1(nums, 1, nums.length));
    }

    public int rob1(int[] nums, int l, int r) {
        int[] dp = new int[r - l + 1]; // i位置的最大值
        // dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        dp[l] = nums[l]; // 初始化
        dp[l + 1] = Math.max(nums[l], nums[l + 1]);
        for (int i = l + 2; i < r; i ++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[r - 1];
    }
}
