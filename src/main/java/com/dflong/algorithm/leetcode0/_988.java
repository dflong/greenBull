package com.dflong.algorithm.leetcode0;

public class _988 {

    String min = null;
    public String smallestFromLeaf(TreeNode root) {
       dfs(root, "");
       return min;
    }

    public void dfs(TreeNode root, String s) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            String s1 = (char)(root.val + 'a') + s;
            if (min == null || s1.length() < min.length() || s1.compareTo(min) < 0) {
                min = s1;
            }
        }
        if (root.left != null) {
            dfs(root.left, (char)(root.val + 'a') + s);
        }
        if (root.right != null) {
            dfs(root.right, (char)(root.val + 'a') + s);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(25);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(2);
        _988 s = new _988();
        s.smallestFromLeaf(root);
    }
}
