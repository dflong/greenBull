package com.dflong.algorithm.leetcode0;

public class _951 {

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return isSymmetric(root1, root2);
    }

    public boolean isSymmetric(TreeNode root1, TreeNode root2) {
        if (root1 == root2) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) return false;
        return (isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left)) ||
                (isSymmetric(root1.left, root2.left) && isSymmetric(root1.right, root2.right));
    }
}
