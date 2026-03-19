package com.dflong.algorithm.leetcode0;

public class _153 {

    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        // nums[mid]==x: 不可能，因为数组无重复值，如果成立，则必然有mid==n-1，则必然有low==high==n-1。但当low==high时，我们已经找到m
        while (l < r) { // l == r时就是答案
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[r]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return nums[l];
    }
}
