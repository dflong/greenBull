package com.dflong.algorithm.lcr;

import java.util.LinkedList;
import java.util.Queue;

public class lcr045 {

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean first = true;
            while (size -- > 0) {
                TreeNode poll = queue.poll();
                if (first) {
                    res = poll.val;
                    first = false;
                }

                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
            }
        }

        return res;
    }
}
