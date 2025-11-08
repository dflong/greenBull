package com.dflong.greenbull.leetcode0;

public class _494 {

    public int findTargetSumWays3(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum + target) % 2 != 0) return 0;
        if (Math.abs(target) > sum) return 0;
        int tar = (sum + target) / 2, n = nums.length;
        int[][] dp = new int[n][tar + 1];

        // 行初始化
        for (int i = 0; i < tar + 1; i++) {
            if (nums[0] == i) {
                dp[0][i] = 1;
            }
        }
        // 列初始化
        int zeroNum = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) zeroNum ++;
            dp[i][0] = (int) Math.pow(2, zeroNum);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= tar; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i]) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[n - 1][tar];
    }

    public static void main(String[] args) {
        new _494().findTargetSumWays3(new int[]{1,2,1}, 0);
    }

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (Math.abs(target) > sum) {
            return 0;
        }
        if ((sum + target) % 2 != 0) {
            return 0;
        }
        int left = (sum + target) / 2;

        int[] dp = new int[left + 1];
        dp[0] = 1;

        for (int i = 0; i < n; i ++) {
            for (int j = left; j >= nums[i]; j --) {
                dp[j] += dp[j - nums[i]];
            }
        }

        return dp[left];
    }


    /**
     * 回溯
     */
    int[] nums;
    int target;
    int n;

    int res = 0;
    public int findTargetSumWays1(int[] nums, int target) {
        this.nums = nums;
        n = nums.length;

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        this.target = (target + sum) / 2;

        dfs(0, 0);
        return res;
    }

    public void dfs(int idx, int sum) {
        if (sum == target) {
            res ++;
            return;
        }
        if (sum > target) {
            return;
        }

        for (int j = idx; j < n; j ++) {
            sum += nums[j];
            dfs(j + 1, sum);
            sum -= nums[j];
        }
    }
}
