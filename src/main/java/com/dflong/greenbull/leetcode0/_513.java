package com.dflong.greenbull.leetcode0;

import java.util.LinkedList;
import java.util.Queue;

public class _513 {

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return 0;
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int index = 0;
            while (size -- > 0) {
                TreeNode node = queue.poll();
                if (index ++ == 0) {
                    res = node.val;
                }

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }

        return res;
    }
}
