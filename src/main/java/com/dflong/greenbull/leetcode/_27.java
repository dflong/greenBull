package com.dflong.greenbull.leetcode;

public class _27 {

    public int removeElement(int[] nums, int val) {
        int delIndex = 0; // 要删除的位置
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[delIndex ++] = nums[j];
            }
        }
        return delIndex;
    }
}
