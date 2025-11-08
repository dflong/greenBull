package com.dflong.greenbull.leetcode0;

public class _581 {

    public static void main(String[] args) {
        new _581().findUnsortedSubarray(new int[]{1,3,2,3,3});
    }

    public int findUnsortedSubarray(int[] nums) {
        int min = nums[0];
        int max = nums[nums.length - 1];
        int l = -1, r = - 1;
        for (int i = 1; i < nums.length; i++) {
            if (min > nums[i]) {
                r = i;
            } else {
                min = nums[i];
            }

            if (max < nums[nums.length - 1 - i]) {
                l = nums.length - 1 - i;
            } else {
                max = nums[nums.length - 1 - i];
            }
        }
        return r == -1 ? 0 : r - l + 1;
    }
}
