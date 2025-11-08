package com.dflong.greenbull.leetcode;

public class _81 {

    public boolean search(int[] nums, int target) {
        // 二分查找 2,5,6,0,0,1,2
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < nums[r]) {
                // 右边有序
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else if (nums[mid] > nums[r]) {
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                r --;
            }
        }
        return false;
    }
}
