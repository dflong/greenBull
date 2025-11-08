package com.dflong.greenbull.leetcode;

public class _62 {

    public int uniquePaths(int m, int n) {
        //数组含义  dp[m][n] 第m行n列有多少条路径
        int[][] dp = new int[m][n];

        // 递推公式 dp[m][n] = dp[m - 1][n] + dm[m][n - 1]

        // 初始化
        for (int i = 0; i < m; i ++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < n; i ++) {
            dp[0][i] = 1;
        }

        // 遍历顺序
        for (int i = 1; i < m; i ++) {
            for (int j = 1; j < n; j ++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}
