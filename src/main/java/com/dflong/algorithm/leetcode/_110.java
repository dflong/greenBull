package com.dflong.algorithm.leetcode;

public class _110 {

    public boolean isBalanced(TreeNode root) {
        return isBalanced1(root) != - 1;
    }

    public int isBalanced1(TreeNode root) {
        if (root == null) return 0;
        int left = isBalanced1(root.left);
        if (left == -1) return -1;
        int right = isBalanced1(root.right);
        if (right == -1) return -1;
        if (Math.abs(left - right) > 1) return -1;
        return 1 + Math.max(left, right);
    }
}
