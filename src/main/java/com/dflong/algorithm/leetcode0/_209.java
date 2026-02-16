package com.dflong.algorithm.leetcode0;

public class _209 {

    public static void main(String[] args) {

        System.out.println(minSubArrayLen(7, new int[] {2,3,1,2,4,3}));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int l = 0, r = 0, n = nums.length;
        int sum = 0, min = n + 1;
        while (r < n) {
            sum += nums[r ++];
            while (target <= sum) {
                min = Math.min(min, r - l);
                sum -= nums[l ++];
            }
        }

        return min == n + 1 ? 0 : min;
    }
}
