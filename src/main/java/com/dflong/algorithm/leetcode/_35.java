package com.dflong.algorithm.leetcode;

public class _35 {

    /**
     * 暴力解法
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }

        return nums.length;
    }

    /**
     * 二分 []
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert1(int[] nums, int target) {
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

        // 目标在最前面0的位置 0 = right(-1) + 1
        // 目标是数字其中一个 mid
        // 目标插入数组 right + 1
        // 目标在最后 right + 1;

        return R + 1;
    }

    /**
     * 二分 [)
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert2(int[] nums, int target) {
        int L = 0, R = nums.length;
        while (L <= R) {
            int mid = L + (R - L) / 2;
            if (nums[mid] > target) {
                R = mid;
            } else if (nums[mid] < target) {
                L = mid + 1;
            } else {
                return mid;
            }
        }

        // 目标在最前面0的位置 0 = right + 1
        // 目标是数字其中一个 mid
        // 目标插入数组 right + 1
        // 目标在最后 right + 1;

        return R;
    }
}
