package com.dflong.algorithm.leetcode;

public class _647 {

    public int countSubstrings(String s) {
        // 判断是否是回文串
        boolean[][] dp = new boolean[s.length()][s.length()];

        // dp[i][j] = dp[i + 1][j - 1]

        int res = 0;
        for (int i = s.length() - 1; i >= 0; i --) {
            for (int j = i; j < s.length(); j ++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 2) {
                        res ++;
                        dp[i][j] = true;
                    } else if (dp[i + 1][j - 1]) {
                        res ++;
                        dp[i][j] = true;
                    }
                }
            }
        }

        return res;
    }
}
