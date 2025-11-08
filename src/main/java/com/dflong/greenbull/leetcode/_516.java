package com.dflong.greenbull.leetcode;

public class _516 {

    public int longestPalindromeSubseq(String s) {
        // s的最长子序列长度
        int[][] dp = new int[s.length()][s.length()];

        // dp[i][j] = dp[i + 1][j -1] + 2
        // dp[i][j]= dp[i + 1][j], dp[i][j - 1]

        // 初始化
        for (int i = 0; i < s.length(); i ++) {
            dp[i][i] = 1;
        }

        // 遍历顺序
        for(int i = s.length() - 1; i >= 0; i --) {
            for (int j = i + 1; j < s.length(); j ++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j -1] + 2;
                } else {
                    dp[i][j]= Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][s.length() - 1];
    }
}
