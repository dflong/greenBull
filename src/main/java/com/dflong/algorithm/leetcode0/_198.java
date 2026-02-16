package com.dflong.algorithm.leetcode0;

public class _198 {

    public static void main(String[] args) {
        _198 v = new _198();
        int rob = v.rob(new int[]{0});
    }

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i ++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[n - 1];
    }
}
