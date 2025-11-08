package com.dflong.greenbull.leetcode0;

public class _740 {

    public int deleteAndEarn(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] sum = new int[max + 1];
        for (int num : nums) {
            sum[num] += num;
        }

        int[] dp = new int[max + 1];
        dp[0] = sum[0];
        dp[1] = Math.max(sum[0], sum[1]);

        for (int i = 2; i <= max; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sum[i]);
        }
        return dp[max];
    }
}
