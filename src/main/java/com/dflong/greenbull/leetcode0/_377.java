package com.dflong.greenbull.leetcode0;

public class _377 {

    public static void main(String[] args) {
        new _377().combinationSum41(new int[] {1,2,3}, 4);
    }

    // 二维数组
    public int combinationSum41(int[] nums, int target) {
        int[][] dp = new int[nums.length + 1][target + 1];

        // dp 初始化
        dp[0][0] = 1;
        for (int j = 0; j <= target; j++) {
            for (int i = 1; i <= nums.length; i++) {
                if(j >= nums[i-1]) {
                    dp[i][j] = dp[i-1][j] + dp[nums.length][j-nums[i-1]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[nums.length][target];
    }

    // 先背包后物品(排列)
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i <= target; i ++) {
            for (int j = 0; j <= n; j ++) {
                if (i >= nums[j]) {
                    dp[i] += dp[j - nums[j]];
                }
            }
        }
        return dp[target];
    }

}
