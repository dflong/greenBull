package com.dflong.greenbull.leetcode;

public class _235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                return root; // 位于两个节点之间就是结果
            }
        }
        return null;
    }
}
