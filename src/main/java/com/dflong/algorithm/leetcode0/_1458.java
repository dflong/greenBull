package com.dflong.algorithm.leetcode0;

public class _1458 {

    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = Integer.MIN_VALUE;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = Integer.MIN_VALUE;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int sum = nums1[i - 1] * nums2[j - 1];
                if (sum > 0 && dp[i - 1][j - 1] > 0) {
                    dp[i][j] = Math.max(Math.max(dp[i - 1][j - 1] + sum, dp[i - 1][j]), dp[i][j - 1]);
                } else {
                    dp[i][j] = Math.max(sum, Math.max(dp[i - 1][j - 1], Math.max(dp[i - 1][j], dp[i][j - 1])));
                }
            }
        }
        return dp[m][n];
    }
}
