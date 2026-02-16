package com.dflong.algorithm.leetcode0;

import java.util.Arrays;

public class _674 {

    public int findLengthOfLCIS(int[] nums) {
        int max = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = Math.max(dp[i], dp[i - 1] + 1);
            }
            if (dp[i] > max) max = dp[i];
        }
        return max;
    }
}
