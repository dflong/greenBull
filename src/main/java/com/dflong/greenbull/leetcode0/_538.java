package com.dflong.greenbull.leetcode0;

public class _538 {

    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    int sum = 0;
    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.right);
        root.val += sum;
        sum = root.val;
        dfs(root.left);
    }
}
