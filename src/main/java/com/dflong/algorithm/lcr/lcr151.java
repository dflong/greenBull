package com.dflong.algorithm.lcr;

import java.util.*;

public class lcr151 {

    List<List<Integer>> res =  new ArrayList<>();

    public List<List<Integer>> decorateRecord(TreeNode root) {
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean reverse = false;
        while (!queue.isEmpty()) {

            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size -- > 0) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
            }
            if (reverse) {
                Collections.reverse(list);
            }
            reverse = !reverse;
            res.add(list);
        }
        return res;
    }
}
