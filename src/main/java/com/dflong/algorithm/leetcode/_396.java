package com.dflong.algorithm.leetcode;

public class _396 {

    public static void main(String[] args) {
        new _396().maxRotateFunction(new int[] {4,3,2,6});
    }

    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        // 第i位开始的元素和
        int[] dp = new int[n];
        // dp[i] = dp[i - 1} + sum - n * nums[n - i]

        int sum = 0;
        for (int i = 0; i < n; i ++) {
            sum += nums[i];
            dp[0] += i * nums[i];
        }

        int res = dp[0];
        for (int i = 1; i < n ; i ++) {
            dp[i] = dp[i - 1] + sum - n * nums[n - i];
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
