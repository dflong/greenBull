package com.dflong.greenbull.leetcode0;

public class _814 {

    public TreeNode pruneTree(TreeNode root) {
        dfs(root);
        return root;
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
