package com.dflong.greenbull.leetcode0;

import java.util.Deque;
import java.util.LinkedList;

public class _111 {

    public int minDepth(TreeNode root) {
        int res = 0;
        if (root == null) return res;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            res ++;
            while (size -- > 0) {
                TreeNode poll = queue.poll();
                if (poll.left == null && poll.right == null) {
                    return res;
                }
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
        }
        return res;
    }
}
