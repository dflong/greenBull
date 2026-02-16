package com.dflong.algorithm.leetcode0;

public class _922 {

    public static void main(String[] args) {
        new _922().sortArrayByParityII(new int[]{4,2,5,7});
    }

    public int[] sortArrayByParityII(int[] nums) {
        // 如果偶数位是奇数，交换
        int j = 1;
        for (int i = 0; i < nums.length; i += 2) {
            if (nums[i] % 2 == 1) {
                while (nums[j] % 2 == 1) {
                    j += 2;
                }
                swap(nums, i, j);
            }
        }
        return nums;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
