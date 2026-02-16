package com.dflong.algorithm.leetcode0;

public class _LCP67 {

    public TreeNode expandBinaryTree(TreeNode root) {
        dfs(root);
        return root;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;

        if (root.left != null) {
            TreeNode newNode = new TreeNode(-1);
            newNode.left = root.left;
            root.left = newNode;
            dfs(root.left.left);
        }
        if (root.right != null) {
            TreeNode newNode = new TreeNode(-1);
            newNode.right = root.right;
            root.right = newNode;
            dfs(root.right.right);
        }
    }
}
