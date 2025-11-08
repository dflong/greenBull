package com.dflong.greenbull.leetcode;

public class _303 {


}

class NumArray {

    int[] sum;
    int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
        sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i ++) {
            sum[i] = sum[i - 1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return sum[right] - sum[left] + nums[left];
    }
}
