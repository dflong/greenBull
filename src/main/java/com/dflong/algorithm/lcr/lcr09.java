package com.dflong.algorithm.lcr;

public class lcr09 {

    public int sumNumbers(TreeNode root) {
        dfs(root, root.val);
        return res;
    }

    int res = 0;

    void dfs(TreeNode root, int sum) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            res += sum;
        }

        if (root.left != null) {
            dfs(root.left, sum * 10 + root.left.val);
        }

        if (root.right != null) {
            dfs(root.right, sum * 10 + root.right.val);
        }
    }

}
