package com.dflong.algorithm.leetcode0;

public class _152 {

    public static void main(String[] args) {
        _152 v = new _152();
        v.maxProduct(new int[] {2,3,-2,4});
    }

    public int maxProduct(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] == 0) {
                dp[i - 1] = 1;
            }
            dp[i] = dp[i - 1] * nums[i];
            int temp = Math.max(nums[i], dp[i]);
            max = Math.max(max, temp);

        }

        dp = new int[nums.length];
        dp[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i > 0; i--) {
            if (dp[i + 1] == 0) {
                dp[i + 1] = 1;
            }
            dp[i] = dp[i + 1] * nums[i];
            int temp = Math.max(nums[i], dp[i]);
            max = Math.max(max, temp);
        }

        return max;
    }
}
//int max = nums[0];
//int multiply = 1;
//
//        for (int i = 0; i < nums.length; i++) {
//multiply *= nums[i];
//max = Math.max(max, multiply);
//            if (nums[i] == 0) {
//multiply = 1;
//        }
//        }