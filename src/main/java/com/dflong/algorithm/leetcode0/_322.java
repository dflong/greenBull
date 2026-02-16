package com.dflong.algorithm.leetcode0;

import java.util.Arrays;

public class _322 {

    public static void main(String[] args) {
        _322 v = new _322();
        int i = v.coinChange(new int[]{1, 2, 5}, 11);
        System.out.println(i);
    }

    // coins {1, 2, 5}硬币组成, amount金额
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i ++) {
            for (int j = 1; j <= amount; j ++) {
                if (j >= coins[i]) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? - 1 : dp[amount];
    }

    // coins {1, 2, 5}硬币组成, amount金额
    public int coinChange1(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i ++) {
            Arrays.fill(dp[i], amount + 1);
            dp[i][0] = 0;
        }

        for (int i = coins[0]; i <= amount; i ++) {
            dp[0][i] = Math.min(dp[0][i], dp[0][i - coins[0]] + 1);
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

    public int coinChange2(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int i = 0; i < n; i ++) {
            Arrays.fill(dp[i], amount + 1);
            // 列初始化
            dp[i][0] = 0;
        }

        // 行初始化
        for (int i = coins[0]; i <= amount; i ++) {
            dp[0][i] = Math.min(dp[0][i], dp[0][i - coins[0]] + 1);
        }

        for (int i = 1; i < n; i ++) {
            for (int j = 1; j <= amount; j ++) {
                if (j >= coins[i]) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i]] + 1);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n - 1][amount] == amount + 1 ? -1 : dp[n - 1][amount];
    }
}
