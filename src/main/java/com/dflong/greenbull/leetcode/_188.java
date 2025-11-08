package com.dflong.greenbull.leetcode;

public class _188 {

    public int maxProfit(int k, int[] prices) {
        // dp[i][1] 买入股票 dp[i][2] 卖出股票
        int[][] dp = new int[prices.length][2 * k + 1];

        for (int i = 1; i <  2 * k  + 1; i += 2) {
            dp[0][i] = - prices[0];
        }

        for (int i = 1; i < prices.length; i ++) {
            for (int j = 1; j < 2 * k + 1; j += 2) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]); // 买入
                dp[i][j + 1] = Math.max(dp[i][j] + prices[i], dp[i - 1][j + 1]); // 卖出
            }
        }

        return dp[prices.length - 1][2 * k];
    }
}
