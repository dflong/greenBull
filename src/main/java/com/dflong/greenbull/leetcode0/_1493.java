package com.dflong.greenbull.leetcode0;

public class _1493 {

    public int longestSubarray(int[] nums) {
        int max = 0;
        int count = 0; // 非1的数量
        int l = 0, r = 0, n = nums.length;
        while (r < n) {
            if (nums[r] != 1) {
                count ++;
            }
            while (count > 1) {
                max = Math.max(max, r - l - 1);
                if (nums[l] != 1) {
                    count --;
                }
                l ++;
            }
            r ++;
        }
        return Math.max(max, r - l - 1);
    }
}
