package com.dflong.greenbull.leetcode0;

public class _654 {

    int[] nums;
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        this.nums = nums;
        return buildTree(0, nums.length - 1);
    }

    public TreeNode buildTree(int L, int R) {
        if (L > R) return null;

        int maxIndex = L;
        for (int i = L; i <= R; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = buildTree(L, maxIndex - 1);
        root.right = buildTree(maxIndex + 1, R);
        return root;
    }
}
