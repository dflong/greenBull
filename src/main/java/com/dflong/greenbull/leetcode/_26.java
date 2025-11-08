package com.dflong.greenbull.leetcode;

// https://programmercarl.com/0236.%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E6%9C%80%E8%BF%91%E5%85%AC%E5%85%B1%E7%A5%96%E5%85%88.html#%E6%80%9D%E8%B7%AF
public class _26 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root; // 当前节点等于p、q就返回

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) { // 两个节点都找到了，就返回父节点
            return root;
        } else if (left != null) { // 其中一个没找到就返回另一个
            return left;
        } else if (right != null) { // 其中一个没找到就返回另一个
            return right;
        } else {
            return null;
        }
    }

}
