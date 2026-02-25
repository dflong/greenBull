package com.dflong.algorithm.lcr;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lcr149 {

    public int[] decorateRecord(TreeNode root) {
        if (root == null) return new int[0];
        List<Integer> list = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            list.add(poll.val);
            if (poll.left != null) queue.add(poll.left);
            if (poll.right != null) queue.add(poll.right);
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}
