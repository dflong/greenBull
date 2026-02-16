package com.dflong.algorithm.leetcode0;

public class _687 {

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return res;
    }

    int res = 0;
    public int dfs(TreeNode root) {
        if (root == null) return 0;

        int L = dfs(root.left);
        int R = dfs(root.right);

        if (root.left != null && root.val == root.left.val) {
            L += 1;
        } else {
            L = 0;
        }
        if (root.right != null && root.val == root.right.val) {
            R += 1;
        } else {
            R = 0;
        }

        res = Math.max(res, L + R);
        return Math.max(L, R);
    }
}
