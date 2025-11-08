package com.dflong.greenbull.leetcode;

import java.util.Arrays;

public class _416 {

    /**
     *    0   1   2   3   4   5   6   7   8   9   10   11
     * 1  0   1   1   1   1   1   1   1   1   1    1    1
     * 5  0   1   1   1   1   5   6   6   6   6    6    6
     * 5  0   1   1   1   1   5   6   6   6   6    10   11
     * 11 0   .....
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) return false;
        int target = sum / 2; // 背包容量
        Arrays.sort(nums);

        // n件物品，容量target的背包最大价值
        int[][] dp = new int[nums.length][target + 1];

        // 初始化
        for (int i = 0; i <= target; i++) {
            if (nums[0] <= i) {
                dp[0][i] = nums[0];
            }
        }

        // 遍历顺序
        for (int i = 1; i < nums.length; i ++) {
            for (int j = 0; j <= target; j ++) {
                if (nums[i] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[nums.length - 1][target] == target;
    }

    public static void main(String[] args) {
        new _416().canPartition(new int[]{1, 5, 11, 5});
    }

    public boolean canPartition1(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) return false;
        int target = sum / 2; // 背包容量
        Arrays.sort(nums);

        // n件物品，容量target的背包最大价值
        int[] dp = new int[target + 1];

        // 初始化

        // 遍历顺序
        for (int i = 1; i < nums.length; i ++) {
            for (int j = target; j >= 0; j --) {
                if (nums[i] <= j) {
                    dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
                }
            }
        }

        return dp[target] == target;
    }
}
