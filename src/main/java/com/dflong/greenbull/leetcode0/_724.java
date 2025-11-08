package com.dflong.greenbull.leetcode0;

public class _724 {

    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int left = 0;
        int right = sum;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) {
                left += nums[i - 1];
            }
            right -= nums[i];
            if (left == right) return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        new _724().pivotIndex(new int[]{1, 7, 3, 6, 5, 6});
    }
}
