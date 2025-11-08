package com.dflong.greenbull.leetcode0;

import java.util.HashSet;
import java.util.Set;

public class _2461 {

    public static void main(String[] args) {
        new _2461().maximumSubarraySum(new int[]{9,18,10,13,17,9,19,2,1,18}, 5);
    }

    public long maximumSubarraySum(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        long max = 0, sum = 0;
        int l = 0, r = 0;
        for (int i = 0; i < nums.length; i++) {
            while (set.contains(nums[i])) {
                set.remove(nums[l]);
                sum -= nums[l];
                l ++;
            }
            set.add(nums[i]);
            sum += nums[i];
            if (r - l + 1 == k) {
                max = Math.max(max, sum);
                sum -= nums[l];
                set.remove(nums[l]);
                l ++;
            }
            r ++;
        }

        return max;
    }
}
