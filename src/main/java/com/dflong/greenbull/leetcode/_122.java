package com.dflong.greenbull.leetcode;

public class _122 {

    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                sum += prices[i] - prices[i - 1];
            }
        }
        return sum;
    }

    public int maxProfit2(int[] prices) {
        // dp[i][0] 持有股票最大金额 dp[i][1] 不持有
        int[][] dp = new int[prices.length][2];

        // 递推公式
        // dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] - price[i])
        // dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] + price[i])

        // 初始化
        dp[0][0] = - prices[0];
        dp[0][1] = 0;

        // 遍历顺序
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }

        return dp[prices.length - 1][1];
    }
}
