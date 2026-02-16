package com.dflong.algorithm.leetcode0;

public class _801 {

    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0; // 不换位置
        dp[0][1] = 1; // 换位置

        for (int i = 1; i < n; i++) {
            int a1 = nums1[i - 1], a2 = nums1[i];
            int b1 = nums2[i - 1], b2 = nums2[i];

            if ((a1 < a2 && b1 < b2) && (a1 < b2 && b1 < a2)) { // 当前位置不换、换都满足条件
                dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]); // 不换， 前一个位置换、不换都可以
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + 1; // 当前换，前一个位置换、不换都可以
            } else if (a1 < a2 && b1 < b2) { // 当前满足，互换后不满足
                dp[i][0] = dp[i - 1][0]; // 前一个位置也不能换
                dp[i][1] = dp[i - 1][1] + 1; // 当前位置换，前一个必须换
            } else { // 当前不满足
                dp[i][0] = dp[i - 1][1]; // 当前不换，前一个位置必须换
                dp[i][1] = dp[i - 1][0] + 1; // 当前换，前一个不能换
            }
        }

        return Math.min(dp[n - 1][0], dp[n - 1][1]);
    }

    public static void main(String[] args) {
        new _801().minSwap(new int[]{3,3,8,9,10}, new int[]{1,7,4,6,8});
    }
}
