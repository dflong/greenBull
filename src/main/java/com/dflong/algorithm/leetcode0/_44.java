package com.dflong.algorithm.leetcode0;

public class _44 {

    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean [][] dp = new boolean[m + 1][n + 1];
        // 初始化
        dp[0][0] = true;
        for(int j = 2; j < n + 1; j += 2) {
            dp[0][j] = dp[0][j - 2] && p.charAt(j - 1) == '*';
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    // 使用* 、 不使用*
                    dp[i][j] =  dp[i][j - 1] || dp[i - 1][j];
                } else {
                    if (s.charAt(i - 1) == p.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[m][n];
    }
}
