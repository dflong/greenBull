package com.dflong.algorithm.lcr;

public class lcr188 {

    public int bestTiming(int[] prices) {
        // 只能买卖一次
        int n = prices.length;
        int[][] dp = new int[n][2]; // dp[i][0] 持有股票 dp[i][1] 不持有股票
        dp[0][0] = - prices[0]; // 初始化
        dp[0][1] = 0;

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], - prices[i]); // 只能买卖一次
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }

        return dp[n - 1][1];
    }
}
