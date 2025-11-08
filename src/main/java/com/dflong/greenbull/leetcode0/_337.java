package com.dflong.greenbull.leetcode0;

public class _337 {

    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    // [0] 不偷 [1]偷
    public int[] dfs(TreeNode root) {
        if (root == null) return new int[2];

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int val = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); // 不偷当前
        int val1 = root.val + left[0] + right[0]; // 偷当前
        return new int[]{val, val1};
    }
}
