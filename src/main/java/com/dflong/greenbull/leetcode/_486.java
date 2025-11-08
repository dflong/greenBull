package com.dflong.greenbull.leetcode;

public class _486 {

    public boolean predictTheWinner(int[] nums) {
        // dp[i][j] 玩家a、b在数组i、j位置分数差值最大值
        // i < j才有意义, i == j 时只能取nums[i]

        // dp[i][j] = max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1])

        // 初始化
        int len = nums.length;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i ++) {
            dp[i][i] = nums[i];
        }

        for (int i = len - 2; i >= 0; i --) {
            for (int j = i + 1; j <= len - 1; j ++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }

        return dp[0][len - 1] >= 0;
    }
}
