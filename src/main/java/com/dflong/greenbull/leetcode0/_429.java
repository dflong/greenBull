package com.dflong.greenbull.leetcode0;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _429 {

    public List<List<Integer>> levelOrder(Node429 root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Node429> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            while (size -- > 0) {
                Node429 node = queue.poll();
                list.add(node.val);
                if (node.children != null) {
                    queue.addAll(node.children);
                }
            }
            res.add(list);
        }
        return res;
    }
}

class Node429 {
    int val;
    List<Node429> children;
}
