package com.dflong.greenbull.leetcode0;

public class _2320 {

    public int countHousePlacements(int n) {
        int mod = (int) 1e9 + 7;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % mod;
        }

        return (int) ((long) dp[n] * dp[n] % mod);
    }
}
