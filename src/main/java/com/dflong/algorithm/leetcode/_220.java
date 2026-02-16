package com.dflong.algorithm.leetcode;

import java.util.TreeSet;

public class _220 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            long num = nums[i];

            Long floor = set.floor(num);
            Long ceiling = set.ceiling(num);
            if (floor != null && num - floor <= valueDiff) return true;
            if (ceiling != null && ceiling - num <= valueDiff) return true;

            set.add(num);

            if (i >= indexDiff) {
                set.remove((long)nums[i - indexDiff]);
            }
        }

        return false;
    }
}
