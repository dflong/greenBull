package com.dflong.greenbull.leetcode0;

import java.util.Arrays;

public class _132 {

    public int minCut(String s) {
        isHui(s);
        int n = s.length();
        int[] f = new int[n];
        Arrays.fill(f, n);
        for (int i = 0; i < n; i++) {
            if (dp[0][i]) {
                f[i] = 0; // 0到i整体是回文，不需要切割
            } else {
                for (int j = 0; j < i; j++) {
                    if (dp[j + 1][i]) {
                        f[i] = Math.min(f[j] + 1, f[i]);
                    }
                }
            }
        }
        return f[n - 1];
    }

    boolean[][] dp;

    public void isHui(String s) {
        int n = s.length();
        dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) { // j在i的右边
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new _132().minCut("aabb");
    }
}
