package com.dflong.algorithm.leetcode;

public class _112 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        this.targetSum = targetSum;
        return dfs(root, 0);
    }

    int targetSum;

    public boolean dfs(TreeNode root, int sum) {
        if (root == null) return false;

        if (root.left == null && root.right == null) return sum + root.val == targetSum;

        if (root.left != null) {
            boolean l = dfs(root.left, sum + root.val);
            if (l) return true;
        }

        if (root.right != null) {
            boolean r = dfs(root.right, sum + root.val);
            if (r) return true;
        }

        return false;
    }
}
