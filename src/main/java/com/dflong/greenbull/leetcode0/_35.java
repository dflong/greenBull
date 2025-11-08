package com.dflong.greenbull.leetcode0;

public class _35 {

    public static void main(String[] args) {
        _35 v = new _35();
        int i = v.searchInsert(new int[]{1,3,5,6}, 2);
    }

    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return r;
    }


}
