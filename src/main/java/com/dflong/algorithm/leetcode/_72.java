package com.dflong.algorithm.leetcode;

public class _72 {

    /**
     *    r  o  s
     * h  1  2  3
     * o  2  1  2
     * r  2  2  2
     * s  3  3  2
     * e  4  3  3
     *
     */
    public int minDistance(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        // s.charAt(i) == t.charAt(j)
        // dp[i][j] = dp[i - 1][j -1]
        // dp[i][j] = min(dp[i - 1][j], dp[i][j - 1] + 1

        // 初始化
        for (int i = 0; i <= s.length(); i ++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= t.length(); j ++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= s.length(); i ++) {
            for (int j = 1; j <= t.length(); j ++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j- 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]) , dp[i - 1][j - 1]) + 1;
                }
            }
        }

        return dp[s.length()][t.length()];
    }
}
