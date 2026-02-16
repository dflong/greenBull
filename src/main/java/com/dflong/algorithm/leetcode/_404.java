package com.dflong.algorithm.leetcode;

public class _404 {

    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root);
        return sum;
    }

    int sum = 0;

    public TreeNode dfs(TreeNode root) {
        if (root == null) return null;

        TreeNode left = dfs(root.left);
        TreeNode right = dfs(root.right);
        if (left != null && left.left == null && left.right == null) {
            sum += left.val;
        }
        return root;
    }
}
