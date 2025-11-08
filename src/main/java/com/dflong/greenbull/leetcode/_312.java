package com.dflong.greenbull.leetcode;

public class _312 {

    public static void main(String[] args) {
        new _312().maxCoins(new int[]{3,1,5,8});
    }

    public int maxCoins(int[] nums) {
        int n = nums.length;

        int[] val = new int[n + 2];
        val[0] = val[n + 1] = 1;
        for (int i = 1; i < n + 1; i ++) {
            val[i] = nums[i - 1];
        }

        // dp[i][j] 开区间(i,j)的硬币最大值
        int[][] dp = new int[n + 2][n + 2];
        for (int i = n - 1; i >= 0; i --) { // 左开区间
            for (int j = i + 2; j <= n + 1; j ++) { // 右开区间
                int max = 0;
                for (int k = i + 1; k < j; k ++) { // i<k<j
                    max = Math.max(max, dp[i][k] + val[i] * val[k] * val[j] + dp[k][j]);
                }
                dp[i][j] = max;
            }
        }

        return dp[0][n + 1];
    }
}
