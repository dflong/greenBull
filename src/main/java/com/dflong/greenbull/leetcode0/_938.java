package com.dflong.greenbull.leetcode0;

public class _938 {

    public int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root, low, high);
        return sum;
    }

    int sum = 0;
    public void dfs(TreeNode root, int low, int high) {
        if (root == null) return;
        dfs(root.left, low, high);
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }
        if (root.val > high) {
            return;
        }
        dfs(root.right, low, high);
    }
}
