package com.dflong.greenbull.leetcode0;

public class _701 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        this.val = val;
        return dfs(root);
    }

    int val;
    public TreeNode dfs(TreeNode root) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val > val) {
            root.left = dfs(root.left);
        } else {
            root.right = dfs(root.right);
        }
        return root;
    }
}
