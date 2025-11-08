package com.dflong.greenbull.leetcode0;

import java.util.LinkedList;
import java.util.Queue;

public class _404 {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size -- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null && node.left.left == null && node.left.right == null) {
                    sum += node.left.val;
                }

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }

        return sum;
    }

    int sum = 0;

    public TreeNode dfs(TreeNode root) {
        if (root == null) return null;
        TreeNode left = dfs(root.left);
        TreeNode right = dfs(root.right);
        if (left != null && left.left == null && left.right == null) {
            sum += left.val;
        }
        return root;
    }

    public int sumOfLeftLeaves1(TreeNode root) {
        dfs(root);
        return sum;
    }
}
