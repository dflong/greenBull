package com.dflong.algorithm.leetcode0;

import java.util.LinkedList;
import java.util.Queue;

public class _116 {

    public Node116 connect(Node116 root) {
        if (root == null) return root;
        Queue<Node116> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Node116 node = queue.poll();
                if (size >= 1) {
                    node.next = queue.peek();
                }
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return root;
    }
}

class Node116 {
    public int val;
    public Node116 left;
    public Node116 right;
    public Node116 next;

    public Node116() {}

    public Node116(int _val) {
        val = _val;
    }

};
