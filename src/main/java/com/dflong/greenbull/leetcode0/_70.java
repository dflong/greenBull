package com.dflong.greenbull.leetcode0;

public class _70 {

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 2;

        if (n < 2) {
            return n;
        }

        for (int i = 2; i < n; i ++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int i = new _70().climbStairs(2, 3);
        System.out.println(i);
    }

    public int climbStairs(int m, int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i <= n; i++) { // 先背包
            for (int j = 1; j <= m; j ++) { // 后物品
                if (i - j >= 0) {
                    dp[i] += dp[i - j];
                }
            }
        }
        return dp[n];
    }
}
