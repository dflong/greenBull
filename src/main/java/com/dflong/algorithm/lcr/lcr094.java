package com.dflong.algorithm.lcr;

import java.util.Arrays;

public class lcr094 {

    public int minCut(String s) {
        int n = s.length();
        dp = new boolean[n][n];
        isHui(s);
        int[] minCnt = new int[n];
        Arrays.fill(minCnt, n);
        for (int i = 0; i < n; i++) {
            if (dp[0][i]) { // 是回文
                minCnt[i] = 0;
            } else {
                for (int j = 0; j < i; j ++) {
                    if (dp[j + 1][i]) { // j + 1到i是回文，则需要切一刀
                        minCnt[i] = Math.min(minCnt[i], minCnt[j] + 1);
                    }
                }
            }
        }

        return minCnt[n - 1];
    }

    boolean[][] dp; // i,j位置是否是回文
    void isHui(String s) {
        char[] array = s.toCharArray();
        for (int i = array.length - 1; i >= 0; i --) {
            for (int j = i; j < array.length; j ++) {
                if (array[i] == array[j]) {
                    if (j - i < 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
            }
        }
    }
}
