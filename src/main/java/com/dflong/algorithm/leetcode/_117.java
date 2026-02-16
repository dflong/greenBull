package com.dflong.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _117 {

    public TreeNode connect(TreeNode root) {
        if (root == null) return root;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                TreeNode node = q.poll();
                if (size != 1) {
                    node.next = q.peek();
                }
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
                size --;
            }

        }
        return root;
    }
}
