package com.dflong.greenbull.leetcode0;

public class _450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        this.val = key;
        return dfs(root);
    }

    int val;

    /**
     * 前序遍历
     *
     */
    public TreeNode dfs(TreeNode root) {
        // 没找到
        if (root == null) return null;
        if (root.val == val) {
            if (root.left == null && root.right == null) {
                // 是叶子结点
                return null;
            } else if (root.left != null && root.right == null) {
                // 只有左子树
                return root.left;
            } else if (root.left == null && root.right != null) {
                // 只有右子树
                return root.right;
            } else {
                // 左右子树都有 把左子树连在右子树的最左子孩子
                TreeNode left = root.left;
                TreeNode cur = root.right;
                while (cur.left != null) {
                    cur = cur.left;
                }
                cur.left = left;
                return root.right;
            }
        }

        if (root.val > val) {
            root.left = dfs(root.left);
        } else {
            root.right = dfs(root.right);
        }
        return root;
    }
}
