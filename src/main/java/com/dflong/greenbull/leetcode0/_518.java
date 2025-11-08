package com.dflong.greenbull.leetcode0;

public class _518 {

    public static void main(String[] args) {
        new _518().change(3, new int[]{2});
    }

    // 先物品后背包(组合)
    public int change1(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount + 1];

        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = dp[j] + dp[j - coins[i]];
            }
        }

        return dp[amount];
    }

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for (int i = 1; i <= amount; i++) {
            if (i % coins[0] == 0) {
                dp[0][i] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < n; i ++) {
            for (int j = 1; j <= amount; j ++) {
                if (j >= coins[i]) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n - 1][amount];
    }
}
