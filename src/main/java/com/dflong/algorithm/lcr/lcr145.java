package com.dflong.algorithm.lcr;

public class lcr145 {

    public boolean checkSymmetricTree(TreeNode root) {
        if (root == null) return true;

        return isSymmetricTree(root.left, root.right);
    }

    boolean isSymmetricTree(TreeNode root, TreeNode root1) {
        if (root == null && root1 == null) return true;
        if (root == null || root1 == null) return false;
        if (root.val != root1.val) return false;

        return isSymmetricTree(root.left, root1.right) && isSymmetricTree(root.right, root1.left);
    }
}
