package com.dflong.algorithm.lcr;

public class lcr176 {

    public boolean isBalanced(TreeNode root) {
        return isB(root) != - 1;
    }

    int isB(TreeNode root) {
        if (root == null) return 0;
        int L = isB(root.left);
        if (L == -1 ) return - 1;
        int R = isB(root.right);
        if (R == -1 ) return - 1;

        if (Math.abs(L - R) > 1) return - 1;

        return Math.max(L, R) + 1; // 当前节点最大深度
    }
}
