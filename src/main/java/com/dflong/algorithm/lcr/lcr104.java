package com.dflong.algorithm.lcr;

public class lcr104 {

    public int combinationSum4(int[] nums, int target) {
        // 求排列， 先背包后物品
        int n = nums.length;
        int[] dp = new int[target + 1]; // 背包大小为target的排列数量
        dp[0] = 1; // 初始化 背包大小为0的排列数量

        for (int j = 0; j <= target; j ++) {
            for (int i = 0; i < n; i ++) {
                if (j - nums[i] >= 0) {
                    dp[j] = dp[j] + dp[j - nums[i]];
                }
            }
        }
        return dp[target];
    }
}
