package com.dflong.greenbull.leetcode;

public class _530 {

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return min;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);

        int temp = root.val - pre;
        if (temp > 0 && temp < min) min = temp;
        pre = root.val;

        dfs(root.right);
    }

    int min = Integer.MAX_VALUE;
    int pre = Integer.MIN_VALUE;
}
