package com.dflong.greenbull.leetcode0;

import java.util.Arrays;

public class _279 {

    public static void main(String[] args) {
    }

    public int numSquares2(int n) {
        int num = (int)Math.pow(n, 0.5d) + 1;
        int[][] dp = new int[num][n + 1];
        for (int i = 0; i < n + 1; i ++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < num; i ++) {
            for (int j = 1; j <= n; j ++) {
                if (j >= i * i) {
                    dp[i][j] = Math.min(dp[i][j - i * i] + 1, dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[num - 1][n];
    }

    public int numSquares1(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n);
        dp[0] = 0;
        for (int i = 1; i * i <= n; i ++) {
            for (int j = i * i; j <= n; j ++) {
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
        return dp[n];
    }
}
