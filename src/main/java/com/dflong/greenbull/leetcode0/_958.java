package com.dflong.greenbull.leetcode0;

import java.util.LinkedList;
import java.util.Queue;

public class _958 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);

        new _958().isCompleteTree(root);
    }

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean empty = false;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll == null) {
                empty = true;
            } else {
                if (empty) return false;
                queue.add(poll.left);
                queue.add(poll.right);
            }
        }
        return true;
    }
}
