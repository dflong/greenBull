package com.dflong.greenbull.leetcode0;

public class _669 {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        this.low = low;
        this.high = high;
        return dfs(root);
    }

    int low, high;

    public TreeNode dfs(TreeNode root) {
        if (root == null) return null;
        if (root.val > high) {
            dfs(root.left);
        }
        if (root.val < low) {
            dfs(root.right);
        }

        root.left = dfs(root.left);
        root.right = dfs(root.right);
        return root;
    }
}
