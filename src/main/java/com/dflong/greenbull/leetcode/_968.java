package com.dflong.greenbull.leetcode;

public class _968 {

    public int minCameraCover(TreeNode root) {
        if (dfs(root) == 0) {
            res ++;
        }
        return res;
    }

    int res = 0;

    // 0没有覆盖 1被覆盖 2是监控, 从下往上
    public int dfs(TreeNode root) {
        if (root == null) return 1; // 空节点默认被覆盖

        int l = dfs(root.left);
        int r = dfs(root.right);

        if (l == 0 || r == 0) { // 有一个没被覆盖，就在父节点放一个摄像头
            res ++;
            return 2;
        }

        if (l == 2 || r == 2) { // 有一个是监控
            return 1;
        }

        return 0;
    }
}
