package com.dflong.greenbull.leetcode0;

public class _1793 {

    public static void main(String[] args) {
        new _1793().maximumScore(new int[]{1,4,3,7,4,5}, 3);
    }

    public int maximumScore(int[] nums, int k) {
        int max = nums[k];
        int min = nums[k];
        int i = k, j = k;
        while (i - 1 >= 0 && j + 1 < nums.length) {
            if (nums[i - 1] > nums[j + 1]) {
                i --;
                min = Math.min(min, nums[i]);
                max = Math.max(max, min * (j - i + 1));
            } else {
                j ++;
                min = Math.min(min, nums[j]);
                max = Math.max(max, min * (j - i + 1));
            }
        }

        while (i - 1 >= 0) {
            i --;
            min = Math.min(min, nums[i]);
            max = Math.max(max, min * (j - i + 1));
        }

        while (j + 1 < nums.length) {
            j ++;
            min = Math.min(min, nums[j]);
            max = Math.max(max, min * (j - i + 1));
        }

        return max;
    }
}
