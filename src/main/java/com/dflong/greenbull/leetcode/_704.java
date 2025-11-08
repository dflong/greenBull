package com.dflong.greenbull.leetcode;

public class _704 {

    /**
     * 定义区间 【】左闭右闭
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int L = 0, R = nums.length - 1;
        while (L <= R) {
            int mid = L + (R - L) / 2;
            if (nums[mid] > target) {
                R = mid - 1;
            } else if (nums[mid] < target) {
                L = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


    /**
     * 定义区间 【）左闭右开， 所以右边界需要往右移一位
     * @param nums
     * @param target
     * @return
     */
    public int search1(int[] nums, int target) {
        int L = 0, R = nums.length;
        while (L < R) {
            int mid = L + (R - L) / 2;
            if (nums[mid] > target) {
                R = mid;
            } else if (nums[mid] < target) {
                L = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
