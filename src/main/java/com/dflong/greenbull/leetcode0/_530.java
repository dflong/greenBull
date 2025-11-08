package com.dflong.greenbull.leetcode0;

import java.util.ArrayList;
import java.util.List;

public class _530 {

    public int getMinimumDifference(TreeNode root) {
        midOrder(root);
        int min = list.get(list.size() - 1);
        for (int i = 1; i < list.size(); i ++) {
            min = Math.min(list.get(i) - list.get(i - 1), min);
        }
        return min;
    }

    List<Integer> list = new ArrayList<>();
    public void midOrder(TreeNode root) {
        if (root == null) return;
        midOrder(root.left);
        list.add(root.val);
        midOrder(root.right);
    }

    int pre = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    public int getMinimumDifference1(TreeNode root) {
        dfs(root);
        return min;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        int temp = root.val - pre;
        if (temp > 0 && temp < min) min = temp;
        pre = root.val;
        dfs(root.right);
    }
}
