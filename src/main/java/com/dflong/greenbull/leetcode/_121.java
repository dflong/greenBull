package com.dflong.greenbull.leetcode;

public class _121 {

    public int maxProfit(int[] prices) {
        int price = prices[0];
        int max = 0;

        for (int i = 1; i < prices.length; i++) {
            price = Math.min(price, prices[i]);
            max = Math.max(max, prices[i] - price);
        }

        return max;
    }

    public int maxProfit1(int[] prices) {
        // dp[i][0] 不持有股票最大现金 dp[i][1]持有
        int[][] dp = new int[prices.length][2];

        // 递推公式
        // dp[i][0] = max(dp[i - 1][0], - price[i])
        // dp[i][1] = max(dp[i - 1][1], dp[i - 0] + price[i])

        // 初始化
        dp[0][0] = - prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }

        return dp[prices.length - 1][1];
    }
}
