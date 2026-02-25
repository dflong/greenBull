package com.dflong.algorithm.lcr;

import java.util.ArrayList;
import java.util.List;

public class lcr153 {

    public List<List<Integer>> pathTarget(TreeNode root, int target) {
        this.target = target;
        dfs(root, 0);

        return res;
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int target;

    void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }

        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum + root.val == target) {
                res.add(new ArrayList<>(path));
            }
            path.remove(path.size() - 1);
            return;
        }

        dfs(root.left, sum + root.val);
        dfs(root.right, sum + root.val);
        path.remove(path.size() - 1);
    }
}
