package com.dflong.algorithm.leetcode;

public class _98 {

    public boolean isValidBST(TreeNode root) {
        dfs(root);
        return res;
    }

    long min = Long.MIN_VALUE;
    boolean res = true;

    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (root.val <= min) {
            res = false;
            return;
        } else {
            min = root.val;
        }
        dfs(root.right);
    }
}
