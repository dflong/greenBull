package com.dflong.algorithm.leetcode0;

public class _2266 {

    public int countTexts(String pressedKeys) {
        int MOD = 1_000_000_007;
        int n = pressedKeys.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];
            char c = pressedKeys.charAt(i - 1);
            if (i - 2 >= 0 && pressedKeys.charAt(i - 2) == c) {
                dp[i] = (dp[i - 2] + dp[i]) % MOD;
            }
            if (i - 3 >= 0 && pressedKeys.charAt(i - 3) == c && pressedKeys.charAt(i - 2) == c) {
                dp[i] = (dp[i - 3] + dp[i]) % MOD;
            }
            if ((c == '7' || c == '9') && i - 4 >= 0 &&
                    pressedKeys.charAt(i - 4) == c &&
                    pressedKeys.charAt(i - 3) == c &&
                    pressedKeys.charAt(i - 2) == c) {
                dp[i] = (dp[i - 4] + dp[i]) % MOD;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        new _2266().countTexts("22233");
    }
}
