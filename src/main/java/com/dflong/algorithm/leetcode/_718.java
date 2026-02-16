package com.dflong.algorithm.leetcode;

public class _718 {

    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        // i,j位置的最长重复子数组
        int[][] dp = new int[n][m];

        // nums1[i] == nums2[j], dp[i][j] = dp[i - 1][j - 1] + 1

        int res = 0;
        // 初始化
        for (int i = 0; i < n; i ++) {
            if (nums1[i] == nums2[0]) {
                dp[i][0] = 1;
                res = 1;
            }
        }

        for (int i = 0; i < m; i ++) {
            if (nums1[0] == nums2[i]) {
                dp[0][i] = 1;
                res = 1;
            }
        }

        /**    3, 2, 1, 4, 7
         * 1   0  0  1  0  0
         * 2   0  1  0  0  0
         * 3   1  0  0  0  0
         * 2   0  2  0  0  0
         * 1   0  0  3  0  0
         */
        for (int i = 1; i < n; i ++) {
            for (int j = 1; j < m; j ++) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }
}
