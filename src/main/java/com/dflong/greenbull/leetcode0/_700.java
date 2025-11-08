package com.dflong.greenbull.leetcode0;

public class _700 {

//    public TreeNode searchBST(TreeNode root, int val) {
//        if (root == null) return null;
//        if (root.val == val) return root;
//
//        TreeNode treeNode = searchBST(root.left, val);
//        if (treeNode != null) return treeNode;
//        return searchBST(root.right, val);
//    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;

        if (val > root.val) return searchBST(root.left, val);
        return searchBST(root.right, val);
    }
}
