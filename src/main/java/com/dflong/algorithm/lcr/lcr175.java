package com.dflong.algorithm.lcr;

public class lcr175 {

    public int calculateDepth(TreeNode root) {
        // 二叉树最大深度
        if (root == null) return 0;

        int leftDepth = calculateDepth(root.left);
        int rightDepth = calculateDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
