package com.dflong.algorithm.leetcode0;

public class _1749 {

    public static void main(String[] args) {
        new _1749().maxAbsoluteSum(new int[]{-7,-1,0,-2,1,3,8,-2,-6,-1,-10,-6,-6,8,-4,-9,-4,1,4,-9});
    }

    // 前缀和
    public int maxAbsoluteSum(int[] nums) {
        int max = Math.max(0, nums[0]), min = Math.min(0, nums[0]);
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + dp[i - 1];
            max = Math.max(max, dp[i]);
            min = Math.min(min, dp[i]);
        }

        return Math.abs(max - min);
    }

    // dp
//    public int maxAbsoluteSum(int[] nums) {
//        int max = nums[0], min = nums[0];
//        int[] maxDp = new int[nums.length];
//        maxDp[0] = nums[0];
//        int[] minDp = new int[nums.length];
//        minDp[0] = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            maxDp[i] = Math.max(maxDp[i - 1] + nums[i], nums[i]);
//            max = Math.max(max, maxDp[i]);
//            minDp[i] = Math.min(minDp[i - 1] + nums[i], nums[i]);
//            min = Math.min(min, minDp[i]);
//        }
//        return Math.max(max, - min);
//    }
}
