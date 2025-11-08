package com.dflong.greenbull.leetcode0;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _515 {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            int max = q.peek().val;
            while (size -- > 0) {
                TreeNode poll = q.poll();
                max = Math.max(max, poll.val);
                if (poll.left != null) q.add(poll.left);
                if (poll.right != null) q.add(poll.right);
            }
            res.add(max);
        }
        return res;
    }
}
