package com.dflong.greenbull.leetcode;

public class _377 {

    public static void main(String[] args) {
        new _377().combinationSum4(new int[]{1, 2, 3}, 4);
    }

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

    // 二维数组不好写
    public int combinationSum4(int[] nums, int target) {

        // n个物品可重复取，和为target的排列数量
        int[] dp = new int[target + 1];

        // 递推公式
        // dp[i][j] = dp[i - 1][j] + dp[i][j - nums[i]]

        // 初始化
        dp[0] = 1;

        // 遍历顺序 (求排列)
        for (int j = 0; j <= target; j ++) {
            for (int i = 0; i < nums.length; i ++) {
                if (j >= nums[i]) {
                    dp[j] = dp[j] + dp[j - nums[i]];
                }
            }
        }

        return dp[target];
    }

    // 回溯超时
    int sum = 0, result = 0;
    public void backTracking(int[] nums, int target) {
        if (sum == target) {
            result ++;
            return;
        }
        if (sum > target) {
            return;
        }

        for (int i = 0; i < nums.length; i ++) {
            sum += nums[i];
            backTracking(nums, target);
            sum -= nums[i];
        }
    }
}
