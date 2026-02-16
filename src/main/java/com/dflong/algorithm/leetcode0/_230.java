package com.dflong.algorithm.leetcode0;

public class _230 {

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        midOrder(root);
        return res;
    }

    int idx = 1, k, res = 0;

    public void midOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        midOrder(root.left);
        if (idx == k) {
            res = root.val;
            idx ++;
            return;
        }
        idx ++;
        midOrder(root.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(2);
        treeNode.right = new TreeNode(4);

        new _230().kthSmallest(treeNode, 1);
    }
}
