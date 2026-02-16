package com.dflong.algorithm.leetcode0;

public class _98 {

    long min = - Long.MAX_VALUE;
    boolean res = true;

    public boolean isValidBST(TreeNode root) {
         midOrder(root);
         return res;
    }

    public void midOrder(TreeNode root) {
        if (root == null) return;
        midOrder(root.left);
        if (min >= root.val) {
            res = false;
            return;
        } else {
            min = root.val;
        }
        midOrder(root.right);
    }

}
