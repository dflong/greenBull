package com.dflong.algorithm.lcr;

import java.util.Arrays;

public class lcr102 {

    public int findTargetSumWays(int[] nums, int target) {
        // x + y = sum
        // x - y = target
        // x = (sum + target) / 2 求能否组成x
        int sum = Arrays.stream(nums).sum(), n = nums.length;
        if (Math.abs(target) > sum) {
            return 0;
        }
        if ((sum + target) % 2 != 0) {
            return 0;
        }
        int tar = (sum + target) / 2;
        int[] dp = new int[tar + 1]; // i大小的背包的最大方案数
        dp[0] = 1; // 初始化 背包容量为0的方案数

        for (int i = 0; i < n; i ++) { // 先物品
            for (int j = tar; j >= nums[i]; j --) { // 01后背包
                dp[j] = dp[j] + dp[j - nums[i]];
            }
        }

        return dp[tar];
    }
}
