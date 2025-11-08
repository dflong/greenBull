package com.dflong.greenbull.leetcode0;

public class _108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    public TreeNode build(int[] nums, int l, int r) {
        if (l > r) return null;

        int m = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = build(nums, l, m - 1);
        root.right = build(nums, m + 1, r);
        return root;
    }
}
