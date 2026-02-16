package com.dflong.algorithm.leetcode0;

public class _124 {

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return sum;
    }

    Integer sum = Integer.MIN_VALUE;
    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);

        sum = Math.max(sum, root.val + left + right);
        return Math.max(left, right) + root.val;
    }
}
