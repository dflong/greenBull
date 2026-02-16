package com.dflong.algorithm.leetcode0;

import java.util.ArrayList;
import java.util.List;

public class _971 {

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        this.voyage = voyage;
        dfs(root);
        if (!list.isEmpty() && list.get(0) == -1) {
            list.clear();
            list.add(-1);
        }
        return list;
    }

    List<Integer> list = new ArrayList<>();
    int idx;
    int[] voyage;

    public void dfs(TreeNode root) {
        if (root == null) return;

        if (root.val != voyage[idx ++]) {
            list.clear();
            list.add(-1);
            return;
        }

        if (idx < voyage.length && root.left != null &&
                root.left.val != voyage[idx]) {
            list.add(root.val);
            dfs(root.right);
            dfs(root.left);
        } else {
            dfs(root.left);
            dfs(root.right);
        }
    }
}
