package com.dflong.greenbull.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _515 {

    List<Integer> res = new ArrayList<>();

    public List<Integer> largestValues(TreeNode root) {
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size(), max = q.peek().val;
            while (size > 0) {
                TreeNode node = q.poll();
                max = Math.max(max, node.val);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
                size --;
            }
            res.add(max);
        }
        return res;
    }
}
