package com.dflong.algorithm.leetcode0;

public class _97 {

    public static void main(String[] args) {
        _97 v = new _97();
        boolean interleave = v.isInterleave("a", "", "a");
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if (m + n != s3.length()) return false;

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }

        for (int i = 1; i <= n; i++) {
            dp[0][i] = dp[0][i - 1] && s2.charAt(i - 1) == s3.charAt(i - 1);
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int k = i + j - 1;
                if (s1.charAt(i - 1) == s3.charAt(k)) {
                    dp[i][j] = dp[i - 1][j];
                }
                if (s2.charAt(j - 1) == s3.charAt(k)) {
                    dp[i][j] = dp[i][j - 1] || dp[i][j];
                }
            }
        }
        return dp[m][n];
    }
}
