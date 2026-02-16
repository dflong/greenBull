package com.dflong.algorithm.leetcode;

import java.util.Arrays;

public class _322 {

    public static void main(String[] args) {
        new _322().coinChange(new int[]{2,5,10,1}, 27);
    }

    public int coinChange(int[] coins, int amount) {
        // n个金币组合成amount的最小数量
        int[][] dp = new int[coins.length][amount + 1];

        // 递推公式 dp[i][j] = min(dp[i - 1][j], dp[i][j - coins[i]] + 1

        // 初始化
        for (int i = 0; i < coins.length; i ++) {
            Arrays.fill(dp[i], amount + 1);
            dp[i][0] = 0;
        }

        for (int j = 0; j <= amount; j ++) {
            if (j >= coins[0]) {
                dp[0][j] = Math.min(dp[0][j], dp[0][j - coins[0]] + 1);
            }
        }

        for (int i = 1; i < coins.length; i ++) {
            for (int j = 1; j <= amount; j ++) {
                if (j >= coins[i]) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i]] + 1);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[coins.length - 1][amount] == amount + 1 ? - 1 : dp[coins.length - 1][amount];
    }
}
