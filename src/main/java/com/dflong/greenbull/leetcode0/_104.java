package com.dflong.greenbull.leetcode0;

public class _104 {
    public int maxDepth(TreeNode1 root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) +  1;
    }
}



