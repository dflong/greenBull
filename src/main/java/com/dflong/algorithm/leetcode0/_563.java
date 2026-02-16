package com.dflong.algorithm.leetcode0;

public class _563 {

    public int findTilt(TreeNode root) {
        dfs(root);
        return sum;
    }

    int sum = 0;

    public void dfs(TreeNode root) {
        if (root == null) return;

        dfs(root.left);
        dfs(root.right);

        int left = 0;
        if (root.left != null) {
            left = root.left.val;
            root.val += root.left.val;
        }
        int right = 0;
        if (root.right != null) {
            right = root.right.val;
            root.val += root.right.val;
        }
        sum += Math.abs(left - right);
    }
}
