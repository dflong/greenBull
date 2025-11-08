package com.dflong.greenbull.leetcode0;

public class _1289 {

    public int minFallingPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    dp[i][j] = grid[i][j];
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = 0; k < n; k ++) {
                        if (j != k) {
                            dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + grid[i][j]);
                        }
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < n; j ++) {
            min = Math.min(min, dp[m - 1][j]);
        }
        return min;
    }
}
