package com.dflong.greenbull.leetcode0;

public class _222 {

    int sum = 0;
    public int countNodes(TreeNode1 root) {
        if (root == null) return sum;
        if (root.left != null) {
            countNodes(root.left);
        }
        if (root.right != null) {
            countNodes(root.right);
        }
        sum ++;
        return sum;
    }
}
