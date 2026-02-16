package com.dflong.algorithm.leetcode0;

public class _968 {

    public int minCameraCover(TreeNode root) {
        if (dfs(root) == 0) res ++; // 头节点没有被覆盖
        return res;
    }

    int res = 0;
    public int dfs(TreeNode root) {
        // 0没有覆盖， 1有覆盖 2就是监控
        if (root == null) return 1; // 空结点认为被覆盖才能最小化

        int left = dfs(root.left);
        int right = dfs(root.right);

        // 左、右没有覆盖，说明父节点一定是监控
        if (left == 0 || right == 0) {
            res ++;
            return 2;
        }
        // 有一个是监控，父节点就是覆盖
        if (left == 2 || right == 2) {
            return 1;
        }
        return 0;
    }
}
