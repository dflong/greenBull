package com.dflong.algorithm.lcr;

public class lcr051 {

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    int res = Integer.MIN_VALUE;;

    int dfs(TreeNode root) {
        if (root == null) return 0;

        int l = Math.max(dfs(root.left), 0);
        int r = Math.max(dfs(root.right), 0);

        res = Math.max(res, root.val + l + r);

        return Math.max(l, r) + root.val;
    }
}
