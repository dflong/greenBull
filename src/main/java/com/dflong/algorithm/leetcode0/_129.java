package com.dflong.algorithm.leetcode0;

import java.util.LinkedList;
import java.util.Queue;

public class _129 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        int i = new _129().sumNumbers1(root);
        System.out.println(i);
    }

    public static int sumNumbers(TreeNode1 root) {
        Queue<TreeNode1> queue = new LinkedList<>();

        if (root == null) return 0;

        int sum = 0;
        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            while (size > 0) {
                TreeNode1 node = queue.poll();
                if (node.left != null) {
                    node.left.val = node.left.val + node.val * 10;
                    queue.add(node.left);
                }
                if (node.right != null) {
                    node.right.val = node.right.val + node.val * 10;
                    queue.add(node.right);
                }
                if (node.left == null && node.right == null) {
                    sum += node.val;
                }
                size --;
            }
        }
        return sum;
    }

    public int sumNumbers1(TreeNode root) {
        dfs(root);
        return sum;
    }

    int sum = 0;
    public void dfs(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            sum += root.val;
        }
        if (root.left != null) {
            root.left.val = root.left.val + root.val * 10;
            dfs(root.left);
        }
        if (root.right != null) {
            root.right.val = root.right.val + root.val * 10;
            dfs(root.right);
        }
    }
}
