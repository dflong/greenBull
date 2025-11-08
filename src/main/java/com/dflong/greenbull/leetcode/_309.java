package com.dflong.greenbull.leetcode;

public class _309 {

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][3];

        // 买入股票 dp[i][0] = max(dp[i - 1][0], dp [i - 1][2] - prices[i])
        // 卖出 dp[i][1] = dp[i - 1][0] + prices[i]
        // 卖出 非冷却期 dp[i][2] = max(dp[i - 1][2], dp[i - 1][1])

        dp[0][0] = - prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp [i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1]);
        }

        return Math.max(dp[prices.length - 1][2], dp[prices.length - 1][1]);
    }
}
