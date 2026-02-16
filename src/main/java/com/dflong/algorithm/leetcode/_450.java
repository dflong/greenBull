package com.dflong.algorithm.leetcode;

public class _450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null && root.right != null) {
                return root.right; // 左空，右不空
            } else if (root.right == null && root.left != null) {
                return root.left; // 左不空，右空
            } else if (root.left != null && root.right != null) {
                // 把左子树放在右子树的最左子树节点下
                TreeNode left = root.left;
                TreeNode right = root.right;
                while (right.left != null) {
                    right = right.left;
                }
                right.left = left;
                return root.right;
            } else {
                return null;
            }
        }
        return root;
    }
}
