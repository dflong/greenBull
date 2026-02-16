package com.dflong.algorithm.leetcode0;

import java.util.HashSet;
import java.util.Set;

public class _LCP44 {

    public int numColor(TreeNode root) {
        dfs(root);
        return set.size();
    }

    Set<Integer> set = new HashSet<>();

    public void dfs(TreeNode root) {
        if (root == null) return;
        set.add(root.val);
        if (root.left != null) dfs(root.left);
        if (root.right != null) dfs(root.right);
    }
}
