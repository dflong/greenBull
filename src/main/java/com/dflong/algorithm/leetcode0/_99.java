package com.dflong.algorithm.leetcode0;

public class _99 {

    public void recoverTree(TreeNode root) {
        dfs(root);
        if (x != null && y != null) {
            int tem = x.val;
            x.val = y.val;
            y.val = tem;
        }
    }

    TreeNode pre = null, x = null, y = null;
    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);

        if (pre == null) {
            pre = root;
        } else {
            if (pre.val > root.val) {
                y = root;
                if (x == null) {
                    x = pre;
                }
            }
            pre = root;
        }

        dfs(root.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(2);

        new _99().recoverTree(treeNode);
    }
}
