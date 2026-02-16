package com.dflong.algorithm.leetcode0;

public class _189 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        //            5,6,7,1,2,3,4
        rotate(nums, 3);
    }

    public static void rotate(int[] nums, int k) {

        if (nums == null || nums.length <= 1) {
            return;
        }

        k = k % nums.length;

        int[] res = new int[nums.length];
        int p = 0;

        int j = nums.length - k;
       for (int i = j; i < nums.length; i ++) {
           res[p ++] = nums[i];
       }
       for (int i = 0; i < j; i ++) {
           res[p ++] = nums[i];
       }
       for (int i = 0; i < nums.length; i ++) {
           nums[i] = res[i];
       }
    }
}
