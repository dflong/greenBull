package com.dflong.algorithm.leetcode;

public class _154 {

    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == nums[r]) {
                // nums[mid]==nums[r]
                // 无论 nums[r] 是不是最小值，都有一个它的「替代品」nums[mid]，因此我们可以忽略二分查找区间的右端点
                r --;
            } else if (nums[mid] < nums[r]) {
                r = mid;
            } else {
                l = mid + 1; // 多走一步
            }
        }
        return nums[l];
    }
}
