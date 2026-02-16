package com.dflong.algorithm.lcr;

public class lcr091 {

    public int minCost(int[][] costs) {
        int m = costs.length; // 房子的数量
        int n = 3;
        int[][] dp = new int[m][n];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        // [[17,2,17],[16,16,5],[14,3,19]]
        // dp[i][j] = min() i房子不同颜色的最小值
        for (int i = 1; i < m; i ++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
        }

        return Math.min(Math.min(dp[m - 1][0], dp[m - 1][1]), dp[m - 1][2]);
    }
}
