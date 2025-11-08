package com.dflong.greenbull.leetcode0;

public class _671 {

    int min = 0, res = -1;
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        min = root.val;
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        if (res != -1 && root.val > res) return; // 已经找到，返回
        if (root.val > min) res = root.val; // 赋值
        dfs(root.left);
        dfs(root.right);
    }
}
