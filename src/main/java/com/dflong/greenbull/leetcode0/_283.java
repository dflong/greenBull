package com.dflong.greenbull.leetcode0;

public class _283 {

    public static void main(String[] args) {
        _283 v = new _283();
        int[] nums = new int[] {0,1,0,3,12};
        v.moveZeroes(nums);
        System.out.println();
    }

    public void moveZeroes(int[] nums) {
        int length = nums.length;
        int j = 0; // 指向0

        for (int i = 0; i < length; i ++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j ++;
            }
        }
    }
}
