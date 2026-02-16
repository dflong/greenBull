package com.dflong.algorithm.leetcode;

public class _174 {

    public static void main(String[] args) {
        new _174().calculateMinimumHP(new int[][]{
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}
        });
    }

    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        // 走到m、n需要的最小值 从右下往左上走
        int[][] dp = new int[m][n];

        // dp[i][j] = max(dp[i + 1][j], dp[i][j + 1]) + dungeon[i][j]
        // > 0 ? 0 : dp[i][j]

        // 初始化最后一行一列
        dp[m - 1][n - 1] = Math.min(dungeon[m - 1][n - 1], 0);
        for (int i = m - 2; i >= 0; i --) {
            dp[i][n - 1] = Math.min(dungeon[i][n - 1] + dp[i + 1][n - 1], 0);
        }

        for (int j = n - 2; j >= 0; j --) {
            dp[m - 1][j] = Math.min(dungeon[m - 1][j] + dp[m - 1][j + 1], 0);
        }

        for (int i = m - 2; i >= 0; i --) {
            for (int j = n - 2; j >= 0; j --) {
                dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]) + dungeon[i][j];
                dp[i][j] = Math.min(dp[i][j], 0);
            }
        }

        return - dp[0][0] + 1;
    }
}
