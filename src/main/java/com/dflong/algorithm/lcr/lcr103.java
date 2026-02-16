package com.dflong.algorithm.lcr;

import java.util.Arrays;

public class lcr103 {

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount + 1]; // 组成amount的最小硬币数量
        Arrays.fill(dp, amount + 1);
        dp[0] = 0; // 初始化 金额为0的方案数1

        // 完全背包
        for (int i = 0; i < n; i ++) {
            for (int j = coins[i]; j <= amount; j ++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }

        return dp[amount] == amount + 1 ? - 1 : dp[amount];
    }
}
