package com.dflong.algorithm.leetcode0;

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

    List<Integer> list = new ArrayList<>();
    TreeNode pre;
    int count = 0;
    int maxCount = 0;
    
    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (pre == null || pre.val != root.val) {
            count = 1;
        } else {
            count ++;
        }
        pre = root;
        if (count > maxCount) {
            maxCount = count;
            list.clear();
            list.add(root.val);
        } else if (count == maxCount) {
            list.add(root.val);
        }
        dfs(root.right);
    }
}
