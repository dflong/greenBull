package com.dflong.greenbull.leetcode;

public class _108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    public TreeNode build(int[] nums, int start, int end) {
        if (start > end) return null;
        int m = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = build(nums, start, m - 1);
        root.right = build(nums, m + 1, end);
        return root;
    }
}
