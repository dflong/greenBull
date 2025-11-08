package com.dflong.greenbull.leetcode;

public class _338 {

    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        // 奇数比偶数多一个1
        for (int i = 1; i <= n; i ++) {
            if (i % 2 == 1) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = dp[i / 2];
            }
        }
        // 偶数 = 偶数 / 2
        return dp;
    }
}
