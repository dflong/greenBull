package com.dflong.algorithm.lcr;

public class lcr17 {

    public int findTargetNode(TreeNode root, int cnt) {
        this.cnt = cnt;
        dfs(root);
        return tar;
    }

    int tar = 0, cnt;
    void dfs(TreeNode root) {
        // 右中左
        if (root == null || cnt <= 0) return;
        dfs(root.right);
        if (-- cnt == 0) {
            tar = root.val;
            return;
        }
        dfs(root.left);
    }
}
