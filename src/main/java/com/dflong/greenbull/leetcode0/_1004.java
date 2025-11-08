package com.dflong.greenbull.leetcode0;

public class _1004 {

    public int longestOnes(int[] nums, int k) {
        int max= 0, sum = 0, n = nums.length;
        int l = 0, r= 0;
        while (r < n) {
            if (nums[r] == 0) {
                sum ++;
            }
            while (sum > k) {
                max = Math.max(max, r - l);
                if (nums[l] == 0) {
                    sum --;
                }
                l ++;
            }
            r ++;
        }
        return Math.max(max, r - l);
    }
}
