package com.dflong.greenbull.leetcode0;

public class _LCR165 {

    public static void main(String[] args) {
        new _LCR165().crackNumber(216612);
    }

    public int crackNumber(int ciphertext) {
        String s = ciphertext + "";
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i ++) {
            char c = s.charAt(i - 1);
            dp[i] += dp[i - 1];
            if (i > 1) {
                char c1 = s.charAt(i - 2);
                if (c1 != '0' && (c1 - '0') * 10 + (c - '0') <= 25) {
                    dp[i] += dp[i - 2];
                }
            }
        }

        return dp[n];
    }
}
