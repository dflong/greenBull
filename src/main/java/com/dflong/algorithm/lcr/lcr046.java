package com.dflong.algorithm.lcr;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lcr046 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                if (size == 1) res.add(node.val);
                size --;
            }
        }

        return res;
    }
}
