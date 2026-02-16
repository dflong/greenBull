package com.dflong.algorithm.lcr;

import java.util.Arrays;

public class lcr101 {

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum(), n = nums.length;
        if (sum % 2 != 0) return false; // 得不到结果

        int target = sum / 2;
        int[] dp = new int[target + 1]; // i的背包容量能装物品最大值

        for (int i = 0; i < n; i ++) { // 先物品
            for (int j = target; j >= nums[i]; j --) { // 01后背包
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }

        return dp[target] == target;
    }
}
