package com.dflong.greenbull.leetcode0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _508 {

    Map<Integer, Integer> map = new HashMap<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        int maxCount = 1;
        for (Integer val : map.keySet()) {
            maxCount = Math.max(maxCount, map.get(val));
        }
        List<Integer> list = new ArrayList<>();
        for (Integer val : map.keySet()) {
            if (map.get(val) == maxCount) {
                list.add(val);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i ++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        dfs(root.right);
        if (root.left != null) {
            root.val += root.left.val;
        }
        if (root.right != null) {
            root.val += root.right.val;
        }
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(14);
        root.left.left = new TreeNode(1);
        new _508().findFrequentTreeSum(root);
        System.out.println();
    }
}
