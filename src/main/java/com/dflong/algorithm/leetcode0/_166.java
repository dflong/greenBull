package com.dflong.algorithm.leetcode0;

public class _166 {

    public int jewelleryValue(int[][] frame) {
        int m = frame.length, n = frame[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && j > 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + frame[i][j];
                } else if (i > 0) {
                    dp[i][j] = dp[i - 1][j] + frame[i][j];
                } else if (j > 0) {
                    dp[i][j] = dp[i][j - 1] + frame[i][j];
                } else {
                    dp[i][j] = frame[i][j];
                }
            }
        }

        return dp[m - 1][n - 1];
    }


}
