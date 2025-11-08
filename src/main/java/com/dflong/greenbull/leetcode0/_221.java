package com.dflong.greenbull.leetcode0;

public class _221 {

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        int max = 0;

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == '0') {
                dp[i][0] = 0;
            } else {
                dp[i][0] = 1;
            }
            max = Math.max(max, dp[i][0]);
        }

        for (int i = 1; i < n; i++) {
            if (matrix[0][i] == '0') {
                dp[0][i] = 0;
            } else {
                dp[0][i] = 1;
            }
            max = Math.max(max, dp[0][i]);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        return max * max;
    }
}
