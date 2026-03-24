package com.dflong.algorithm.leetcode0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _652 {

    List<TreeNode> res = new ArrayList<>();
    HashMap<String, Integer> map = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return res;
    }

    String dfs(TreeNode root) {
        if (root == null) {
            return "#";
        }

        String key = root.val +
                "," +
                dfs(root.left) +
                "," +
                dfs(root.right);

        map.put(key, map.getOrDefault(key, 0) + 1);
        if (map.get(key) == 2) {
            res.add(root);
        }
        return key;
    }
}
