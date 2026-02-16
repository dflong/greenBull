package com.dflong.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _501 {

    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    int maxCount = 0, count = 0;
    TreeNode preNode;
    List<Integer> list = new ArrayList<>();

    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);

        if (preNode == null || preNode.val != root.val) {
            count = 1;
        } else {
            count ++;
        }

        preNode = root;
        if (count > maxCount) {
            maxCount = count;
            list.clear();
            list.add(preNode.val);
        } else if (count == maxCount) {
            list.add(preNode.val);
        }

        dfs(root.right);
    }
}
