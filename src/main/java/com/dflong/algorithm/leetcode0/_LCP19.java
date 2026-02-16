package com.dflong.algorithm.leetcode0;

public class _LCP19 {

    public int minimumOperations(String leaves) {
        int n = leaves.length();
        int[][] dp = new int[n][3]; // [][0]红色r [][1]黄色y [][2]红色
        if (leaves.charAt(0) == 'r') {
            dp[0][0] = 0; // 是红色，不需要变换
        } else {
            dp[0][0] = 1; // 是红色，不需要变换
        }
        dp[0][1] = dp[0][2] = dp[1][2] = Integer.MAX_VALUE;
        for (int i = 1; i < n; i ++) {
            // 红色，前一个位置是红色、当前位置是黄色则需要一次变换
            dp[i][0] = dp[i - 1][0] + isYellow(leaves.charAt(i));
            // 黄色， 前一个位置红色、黄色都可以，当前位置是红色则需要一次变换
            dp[i][1] = Math.min(dp[i - 1][1], dp[i - 1][0]) + isRed(leaves.charAt(i));
            if (i >= 2) {
                // 红色， 前一个位置红色、黄色都可以，当前位置是黄色则需要一次变换
                dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][2]) + isYellow(leaves.charAt(i));
            }
        }

        return dp[n - 1][2];
    }

    public int isRed(char r) {
        if (r == 'r') return 1;
        return 0;
    }

    public int isYellow(char y) {
        if (y == 'y') return 1;
        return 0;
    }

    public static void main(String[] args) {
        new _LCP19().minimumOperations("rrryyyrryyyrr");
    }
}
