package com.dflong.algorithm.lcr;

public class lcr096 {

    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if (m + n != s3.length()) return false;
        // s1的i、s2的j是否可以组成s3的int k = i + j - 1
        boolean[][] dp = new boolean[m + 1][n + 1]; // 包含两个前导""
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }

        for (int i = 1; i <= n; i++) {
            dp[0][i] = dp[0][i - 1] && s2.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int i = 1; i <= m; i ++) {
            for (int j = 1; j <= n; j ++) {
                int k = i + j - 1;
                if (s1.charAt(i - 1) == s3.charAt(k)) {
                    dp[i][j] = dp[i - 1][j];
                }
                if (!dp[i][j] && s2.charAt(j - 1) == s3.charAt(k)) {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        return dp[m][n];
    }
}
