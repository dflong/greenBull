package com.dflong.algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _637 {

    List<Double> res = new ArrayList<>();

    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size(), count = size; double sum = 0;
            while (size > 0) {
                TreeNode node = q.poll();
                sum += node.val;
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
                size --;
            }
            res.add(sum / count);
        }
        return res;
    }
}
