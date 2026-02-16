package com.dflong.algorithm.leetcode0;

public class _2787 {

    public int numberOfWays(int n, int x) {
        int MOD = 1000000007;
        int nums = (int)Math.ceil(Math.pow(n, 1.0 / x));
        int[][] dp = new int[nums][n + 1];
        dp[0][1] = 1;
        for (int i = 0; i < nums; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < nums; i++) {
            int k = i + 1;
            for (int j = 1; j <= n; j++) {
                int pow = (int) Math.pow(k, x);
                if (j >= pow) {
                    dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - pow]) % MOD;
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n - 1][n];
    }

    public static void main(String[] args) {
        new _2787().numberOfWays(4, 1);
    }
}
