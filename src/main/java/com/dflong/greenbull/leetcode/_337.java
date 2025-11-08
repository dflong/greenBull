package com.dflong.greenbull.leetcode;

public class _337 {

    public int rob(TreeNode root) {
        int[] dfs = dfs(root);
        return Math.max(dfs[0], dfs[1]);
    }

    public int[] dfs(TreeNode root) {
        if (root == null) return new int[2];

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        // 偷当前
        int steal = root.val + left[0] + right[0];
        // 不偷当前
        int notSteal = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{notSteal, steal};
    }
}
