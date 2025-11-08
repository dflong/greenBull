package com.dflong.greenbull.leetcode0;

public class _188 {

    // 买卖股票最佳时机
    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[k][2];
        for (int i = 0; i < k; i ++) {
            dp[i][0] = - prices[0];
        }

        for (int i = 1; i < prices.length; i ++) {
            for (int j = 0; j < k; j ++) {
                if (j != 0) {
                    dp[j][0] = Math.max(dp[j][0], dp[j - 1][1] - prices[i]);
                } else {
                    dp[j][0] = Math.max(dp[j][0], - prices[i]);
                }
                dp[j][1] = Math.max(dp[j][1], dp[j][0] + prices[i]);
            }
        }
        return dp[k - 1][1];
    }

    public int maxProfit1(int k, int[] prices) {
        int[][] dp = new int[prices.length][2 * k + 1];
        for (int i = 1; i < 2 * k; i += 2) {
            dp[0][i] = - prices[0];
        }

        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < 2 * k; j += 2) {
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i]); // 第一次dp[i - 1][j] = 0
                dp[i][j + 2] = Math.max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i]);
            }
        }
        return dp[prices.length - 1][2 * k];
    }
}
