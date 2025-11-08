package com.dflong.greenbull.leetcode0;

public class _993 {

    public boolean isCousins(TreeNode root, int x, int y) {
        this.x = x;
        this.y = y;
        dfs(root, 0, null);
        return xDepth == yDepth && xParent != yParent;
    }

    int x, y;
    int xDepth, yDepth;
    TreeNode xParent, yParent;
    boolean xFind, yFind;

    public void dfs(TreeNode root, int depth, TreeNode parent) {
        if (root == null) return;

        if (root.val == x) {
            xDepth = depth;
            xParent = parent;
            xFind = true;
        }
        if (root.val == y) {
            yDepth = depth;
            yParent = parent;
            yFind = true;
        }

        if (xFind && yFind) return;
        dfs(root.left, depth + 1, root);

        if (xFind && yFind) return;
        dfs(root.right, depth + 1, root);
    }
}
