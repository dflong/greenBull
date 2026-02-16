package com.dflong.algorithm.leetcode;

public class _123 {

    public int maxProfit(int[] prices) {
        // dp[i][1] 第一天买入
        // dp[i][2] 第一天卖出
        // dp[i][3] 第二天买入
        // dp[i][4] 第二天卖出
        int[][] dp = new int[prices.length][5];

        dp[0][1] = - prices[0];
        dp[0][3] = - prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][1] = Math.max(- prices[i], dp[i - 1][1]);
            dp[i][2] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][2]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }

        return dp[prices.length - 1][4];
    }
}
