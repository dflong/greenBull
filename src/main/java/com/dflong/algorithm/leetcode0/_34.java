package com.dflong.algorithm.leetcode0;

public class _34 {

    public static void main(String[] args) {
        new _34().searchRange1(new int[]{5,7,7,8,8,10}, 8);
    }

    public int[] searchRange1(int[] nums, int target) {

        int begin = -1, end = -1;

        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                begin = mid;
                r = mid - 1; // 右边界在begin左边，往左边继续找更新begin
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        l = 0;
        r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                end = mid;
                l = mid + 1; // 左边界在end右边，往右边继续找更新end
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return new int[] {begin, end};
    }


    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return sear(nums, target, mid);
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }

    public int[] sear(int[] nums, int target, int index) {

        // 向左找
        int l = index;
        int r = index;
        while (l >= 0) {
            if (nums[l] == target) {
                l --;
            } else {
                break;
            }
        }
        while (r < nums.length) {
            if (nums[r] == target) {
                r ++;
            } else {
                break;
            }
        }
        return new int[] {Math.max(0, l + 1), Math.min(r - 1, nums.length - 1)};
    }
}
