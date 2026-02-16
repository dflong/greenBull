package com.dflong.algorithm.leetcode0;

import java.util.LinkedList;
import java.util.Queue;

public class _114 {

    public void flatten1(TreeNode1 root) {

       while (root != null) {
           if (root.left != null) {
                TreeNode1 left = root.left;
                while (left.right != null) {
                    left = left.right;
                }
                left.right = root.right;
                root.right = root.left;
                root.left = null;

                root = root.right;
           } else {
               root = root.right;
           }
       }
    }



    Queue<TreeNode1> queue = new LinkedList<TreeNode1>();

    public void flatten(TreeNode1 root) {
        if (root == null) return;

        preOrder(root.left);
        preOrder(root.right);
        TreeNode1 cur = root;

        while (!queue.isEmpty()) {
            cur.left = null;
            cur.right = queue.poll();
            cur = cur.right;
        }
    }

    public void preOrder(TreeNode1 root) {

        if (root == null) {
            return;
        }
        queue.add(root);
        preOrder(root.left);
        preOrder(root.right);
    }
}
