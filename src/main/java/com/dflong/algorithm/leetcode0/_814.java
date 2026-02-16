package com.dflong.algorithm.leetcode0;

public class _814 {

    public TreeNode pruneTree(TreeNode root) {
        return dfs(root);
    }

    public TreeNode dfs(TreeNode root) {
        if (root == null) return null;

        root.left = dfs(root.left);
        root.right = dfs(root.right);

        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;
    }
}
