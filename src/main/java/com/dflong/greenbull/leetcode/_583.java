package com.dflong.greenbull.leetcode;

public class _583 {

    /**
     * word1 = "sea", word2 = "eat"
     *
     *    e  a  t
     * s  2  3  4
     * e  1  2  3
     * a  2  1  2
     *
     */
    public int minDistance(String s, String t) {
        // s和t相等删除的最小次数
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        // s.charAt(i) == t.charAt(j)
        // dp[i][j] = dp[i - 1][j - 1]
        // dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + 1)

        // 初始化
        for (int i = 0; i <= s.length(); i ++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= t.length(); j ++) {
            dp[0][j] = j;
        }

        // 遍历顺序
        for (int i = 1; i <= s.length(); i ++) {
            for (int j = 1; j <= t.length(); j ++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j- 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }

        return dp[s.length()][t.length()];
    }
}
