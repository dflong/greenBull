package com.dflong.algorithm.leetcode0;

public class _309 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][3];
        dp[0][0] = -prices[0];

        for (int i = 1; i < n; i ++) {
            // 持有股票
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            // 不持有，冷却期
            dp[i][1] = dp[i - 1][0] + prices[i];
            // 不持有，不是冷却期
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }

        return Math.max(dp[n - 1][1], dp[n - 1][2]);
    }


}
