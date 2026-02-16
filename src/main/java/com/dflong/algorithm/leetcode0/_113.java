package com.dflong.algorithm.leetcode0;

import java.util.ArrayList;
import java.util.List;

public class _113 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return result;
    }

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public void dfs(TreeNode root, int targetSum) {
        if (root == null) return;
        list.add(root.val);
        if (root.left == null && root.right == null) {
            int sum = 0;
            for (int i = 0; i < list.size(); i++) {
                sum += list.get(i);
            }
            if (sum == targetSum) {
                result.add(new ArrayList<>(list));
            }
            return;
        }
        if (root.left != null) {
            dfs(root.left, targetSum);
            list.remove(list.size() - 1);
        }
        if (root.right != null) {
            dfs(root.right, targetSum);
            list.remove(list.size() - 1);
        }
    }
}
