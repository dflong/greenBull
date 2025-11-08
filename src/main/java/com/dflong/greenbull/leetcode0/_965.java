package com.dflong.greenbull.leetcode0;

public class _965 {

    public boolean isUnivalTree(TreeNode root) {
        dfs(root);
        return isUnival;
    }

    boolean isUnival = true;

    public void dfs(TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            if (root.val != root.left.val) {
                isUnival = false;
                return;
            }
            dfs(root.left);
        }
        if (root.right != null) {
            if (root.val != root.right.val) {
                isUnival = false;
                return;
            }
            dfs(root.right);
        }
    }
}
