package com.dflong.greenbull.leetcode0;

public class _623 {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        this.val = val;
        this.depth = depth;
        if (1 == depth) {
            TreeNode newL = new TreeNode(val);
            newL.left = root;
            return newL;
        }
        dfs(root, 2);
        return root;
    }

    int val, depth;

    public void dfs(TreeNode root, int curDepth) {
        if (root == null) return;
        if (curDepth == depth) {
            TreeNode newL = new TreeNode(val);
            TreeNode newR = new TreeNode(val);
            newL.left = root.left;
            newR.right = root.right;
            root.left = newL;
            root.right = newR;
            return;
        }

        if (root.left != null) dfs(root.left, curDepth + 1);
        if (root.right != null) dfs(root.right, curDepth + 1);
    }
}
