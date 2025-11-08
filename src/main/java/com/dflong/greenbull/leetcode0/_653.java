package com.dflong.greenbull.leetcode0;

import java.util.HashSet;

public class _653 {

    public boolean findTarget(TreeNode root, int k) {
        dfs(root, k);
        return res;
    }

    boolean res = false;
    HashSet<Integer> set = new HashSet<>();
    public void dfs(TreeNode treeNode, int k) {
        if (treeNode == null) return;
        dfs(treeNode.left, k);
        if (set.contains(k - treeNode.val)) {
            res = true;
            return;
        }
        set.add(treeNode.val);
        dfs(treeNode.right, k);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(3);

        new _653().findTarget(treeNode, 4);
    }
}
