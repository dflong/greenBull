package com.dflong.algorithm.leetcode0;

import java.util.HashSet;
import java.util.Set;

public class _1695 {

    public int maximumUniqueSubarray(int[] nums) {
        int max = 0, sum = 0;
        int l = 0, r = 0;
        Set<Integer> set = new HashSet<>();
        while (r < nums.length) {
            while (set.contains(nums[r])) {
                max = Math.max(max, sum);
                sum -= nums[l];
                set.remove(nums[l]);
                l ++;
            }
            sum += nums[r];
            set.add(nums[r]);
            r ++;
        }
        return Math.max(max, sum);
    }
}
