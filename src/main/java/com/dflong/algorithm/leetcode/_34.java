package com.dflong.algorithm.leetcode;

public class _34 {

    public int[] searchRange(int[] nums, int target) {
        // 分开寻找边界
        return new int[] {getLeft(nums, target), getRight(nums, target)};
    }

    public int getRight(int[] nums, int target) {
        int res = - 1;
        int  L = 0, R = nums.length - 1;
        while (L <= R) {
            int mid = L + (R - L) / 2;
            if (nums[mid] > target) {
                R = mid - 1;
            } else if (nums[mid] < target) {
                L = mid + 1;
            } else {
                res = mid; // 更新结果
                L = mid + 1;
            }
        }
        return res;
    }

    public int getLeft(int[] nums, int target) {
        int res = - 1;
        int  L = 0, R = nums.length - 1;
        while (L <= R) {
            int mid = L + (R - L) / 2;
            if (nums[mid] > target) {
                R = mid - 1;
            } else if (nums[mid] < target) {
                L = mid + 1;
            } else {
                res = mid; // 更新结果
                R = mid - 1;
            }
        }
        return res;
    }
}
