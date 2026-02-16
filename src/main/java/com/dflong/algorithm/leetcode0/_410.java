package com.dflong.algorithm.leetcode0;

import java.util.Arrays;

public class _410 {

    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i < n + 1; i ++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        int[] subSum = new int[n + 1];
        for (int i = 1; i < n + 1; i ++) {
            subSum[i] = subSum[i - 1] + nums[i - 1];
        }
        dp[0][0] = 0;
        for (int i = 1; i < n + 1; i ++) {
            for (int j = 1; j <= Math.min(i, k); j ++) {
                for (int m = 0; m < i; m ++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[m][j - 1], subSum[i] - subSum[m]));
                }
            }
        }
        return dp[n][k];
    }
}
