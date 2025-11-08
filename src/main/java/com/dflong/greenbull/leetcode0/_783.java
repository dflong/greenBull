package com.dflong.greenbull.leetcode0;

public class _783 {

    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return res;
    }

    TreeNode pre = null;
    int res = Integer.MAX_VALUE;

    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);

        if (pre == null) {
            pre = root;
        } else {
            res = Math.min(res, root.val - pre.val);
            pre = root;
        }

        dfs(root.right);
    }
}
