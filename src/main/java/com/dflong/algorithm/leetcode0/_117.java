package com.dflong.algorithm.leetcode0;

import java.util.LinkedList;
import java.util.Queue;

public class _117 {

    public TreeNode1 connect(TreeNode1 root) {
        if (root == null) return null;
        // 层序遍历
        Queue<TreeNode1> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            TreeNode1 poll = null;
            while (size > 0) {
                // 每层的节点
                poll = queue.poll();

                poll.next = queue.peek();

                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
                size --;
            }
            poll.next = null;
        }
        return root;
    }
}

class TreeNode1 {
    public int val;
    public TreeNode1 left;
    public TreeNode1 right;
    public TreeNode1 next;

    public TreeNode1() {}

    public TreeNode1(int _val) {
        val = _val;
    }

    public TreeNode1(int _val, TreeNode1 _left, TreeNode1 _right, TreeNode1 _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
