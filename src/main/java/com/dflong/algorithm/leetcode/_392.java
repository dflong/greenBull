package com.dflong.algorithm.leetcode;

public class _392 {

    /**
     *     a  h  b  g  d  c
     * a   t  t  t  t  t  t
     * b   f  f  t  t  t  t
     * c   f  f  f  f  f  t
     */
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.isEmpty()) return true;
        if (t == null || t.isEmpty()) return false;

        // s是否是t的子序列
        boolean[][] dp = new boolean[s.length()][t.length()];

        // 递推公式 s.charAt(i) == t.charAt(j)
        // dp[i][j] = dp[i - 1][j - 1]
        // else dp[i][j] = dp[i][j - 1]

        // 初始化
        if (s.charAt(0) == t.charAt(0)) {
            dp[0][0] = true;
        }

        for (int i = 1; i < t.length(); i ++) {
            if (s.charAt(0) == t.charAt(i)) {
                dp[0][i] = true;
            } else {
                dp[0][i] = dp[0][i - 1];
            }
        }

        // 遍历顺序
        for (int i = 1; i < s.length(); i ++) {
            for (int j = 1; j < t.length(); j ++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        return dp[s.length() - 1][t.length() - 1];
    }

    public boolean isSubsequence1(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i ++;
            }
            j ++;
        }
        return i == s.length();
    }
}
