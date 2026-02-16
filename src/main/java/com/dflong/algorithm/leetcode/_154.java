package com.dflong.algorithm.leetcode;

public class _154 {

    public int findMin(int[] nums) {
        int L = 0, R = nums.length - 1;
        while (L < R) {
            int mid = L + (R - L) / 2;

            if (nums[mid] == nums[R]) {
                R --;
            } else if (nums[mid] < nums[R]) {
                R = mid;
            } else {
                L = mid + 1; // 多走一步
            }
        }
        return nums[L];
    }
}
