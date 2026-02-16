package com.dflong.algorithm.leetcode0;

public class _647 {

    public int countSubstrings(String s) {
        int n = s.length();
        int res = 0;
        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) { // j在i的右边，肯定是大于等于i
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        dp[i][j] = true;
                        res ++;
                    } else if (dp[i + 1][j - 1]) {
                        dp[i][j] = dp[i + 1][j - 1];
                        res ++;
                    }
                }
            }
        }

        return res;
    }
}
