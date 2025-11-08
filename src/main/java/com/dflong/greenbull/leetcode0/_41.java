package com.dflong.greenbull.leetcode0;

public class _41 {

    public static void main(String[] args) {
        _41 v = new _41();
        int i = v.firstMissingPositive(new int[]{2, 2});
    }

    public int firstMissingPositive(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) { // 处理负数
                nums[i] = len + 1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (num <= len) {
                nums[num - 1] = -Math.abs(nums[num - 1]); // 让存在的全是负数
            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) { // 存在正数说明是没有的
                return i + 1;
            }
        }

        return len + 1;
    }
}
