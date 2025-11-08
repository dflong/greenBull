package com.dflong.greenbull.leetcode0;

public class _543 {

    int deep = 1;

    public int diameterOfBinaryTree(TreeNode root) {
        getDeep(root);
        return deep - 1;
    }

    public int getDeep(TreeNode root) {
        if (root == null) return 0;
        int deep1 = getDeep(root.left);
        int deep2 = getDeep(root.right);
        deep = Math.max(deep, deep1 + deep2 + 1); // 求最大直径
        return Math.max(deep1, deep2) + 1; // 求最大深度
    }
}
