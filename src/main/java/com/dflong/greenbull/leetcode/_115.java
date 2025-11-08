package com.dflong.greenbull.leetcode;

public class _115 {

    /**
     * s = "rabbbit", t = "rabbit"
     *    b  a  g
     * b  1  0  0
     * a  1  1  0
     * b  2  1  0
     * g  2  1  1
     * b  3  1  1
     * a  3  4  1
     * g  3  4  5
     *
     */


    public int numDistinct(String s, String t) {
        // s中子序列t出现的次数
        int[][] dp = new int[s.length()][t.length()];

        // s.charAt(i) == t.charAt(j)
        // dp[i][j] = dp[i - 1][j - 1] + 1
        // else dp[i][j] = dp[i - 1][j]

        // 初始化
        if (s.charAt(0) == t.charAt(0)) {
            dp[0][0] = 1;
        }

        for (int i = 1; i < s.length(); i ++) {
            if (s.charAt(i) == t.charAt(0)) {
                dp[i][0] = dp[i - 1][0] + 1;
            } else {
                dp[i][0] = dp[i - 1][0];
            }
        }

        for (int i = 1; i < s.length(); i ++) {
            for (int j = 1; j < t.length(); j ++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[s.length() - 1][t.length() - 1];
    }
}
