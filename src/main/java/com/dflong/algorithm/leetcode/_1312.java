package com.dflong.algorithm.leetcode;

public class _1312 {
    /**
     *    l e e t c o d e
     *  e 1 1
     *  d 2 2
     *  o
     *  c
     *  t
     *  e
     *  e
     *  l
     */
    public int minInsertions(String s) {
        int n = s.length();
        char[] charArray = s.toCharArray();
        int i = 0, j = charArray.length - 1;
        while (i < j) {
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
            i ++;
            j --;
        }
        String t = new String(charArray);

        int[][] dp = new int[n + 1][n + 1]; // 求最长公共子序列
        for (i = 1; i <= n; i ++ ) {
            for (j = 1; j <= n; j ++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return n - dp[n][n];
    }
}
