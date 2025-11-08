package com.dflong.greenbull.leetcode;

public class _1035 {

    public static void main(String[] args) {
        new _1035().maxUncrossedLines(new int[]{1,3,7,1,7,5}, new int[]{1,9,2,5,1});
    }

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        // i,j位置最长公共子序列
        int[][] dp = new int[n][m];

        // text1.charAt(i) == text2.charAt(j) dp[i][j] = dp[i - 1][j - 1] + 1
        // dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]

        // 初始化
        if (nums1[0] == nums2[0]) {
            dp[0][0] = 1;
        }

        for (int i = 1; i < n; i++) {
            if (nums1[i] == nums2[0]) {
                dp[i][0] = 1;
            } else {
                dp[i][0] = dp[i - 1][0];
            }
        }
        for (int i = 1; i < m; i++) {
            if (nums1[0] == nums2[i]) {
                dp[0][i] = 1;
            } else {
                dp[0][i] = dp[0][i - 1];
            }
        }

        // 遍历顺序
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}
