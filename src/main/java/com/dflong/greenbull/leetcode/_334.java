package com.dflong.greenbull.leetcode;

public class _334 {

    public boolean increasingTriplet(int[] nums) {
        int first = nums[0], second = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > second) {
                return true;
            } else if (num > first) {
                second = num;
            } else {
                first = num;
            }
        }

        return false;
    }
}
