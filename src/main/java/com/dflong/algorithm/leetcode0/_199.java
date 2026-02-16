package com.dflong.algorithm.leetcode0;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _199 {

    public List<Integer> rightSideView(TreeNode1 root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode1> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode1 node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);

                if (size == 1) {
                    res.add(node.val);
                }
                size --;
            }
        }
        return res;
    }
}
