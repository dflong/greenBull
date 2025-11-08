package com.dflong.greenbull.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _513 {

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int res = 0;
        while (!q.isEmpty()) {

            res = q.peek().val;
            int size = q.size();
            while (size -- > 0) {
                TreeNode node = q.poll();
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
        }
        return res;
    }
}
