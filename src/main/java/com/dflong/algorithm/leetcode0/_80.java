package com.dflong.algorithm.leetcode0;

public class _80 {

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        int i = removeDuplicates(nums);
        System.out.println(i);
    }

    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (j < 2) {
                i ++;
            } else if (nums[j] > nums[i - 2]) {
                nums[i] = nums[j];
                i ++;
            }
        }
        return i;
    }

}
