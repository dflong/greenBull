package com.dflong.algorithm.leetcode0;

public class _704 {

    public int search(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        return dfs(0, nums.length - 1);
    }

    int[] nums;
    int target;
    public int dfs(int l, int r) {
        if (l > r) return -1;
        int m = l + (r - l) / 2;
        if (target == nums[m]) {
            return m;
        } else if (target < nums[m]) {
            return dfs(l, m - 1);
        } else {
            return dfs(m + 1, r);
        }
    }
}
