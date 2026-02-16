package com.dflong.algorithm.leetcode;

public class _654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    public TreeNode build(int[] nums, int L, int R) {
        if (L > R) return null;

        int maxIdx = L;
        for (int i = L; i <= R; i++) {
            if (nums[i] > nums[maxIdx]) maxIdx = i;
        }

        TreeNode root = new TreeNode(nums[maxIdx]);
        root.left = build(nums, L, maxIdx - 1);
        root.right = build(nums, maxIdx + 1, R);
        return root;
    }
}
