package com.dflong.greenbull.leetcode0;

import java.util.ArrayList;
import java.util.List;

public class _872 {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        if (root1 != null) {
            dfs(root1, list1);
        }
        if (root2 != null) {
            dfs(root2, list2);
        }

        return list1.equals(list2);
    }

    public void dfs(TreeNode root, List<Integer> lise) {
        if (root == null) return;
        if (root.left == null && root.right == null) {lise.add(root.val);}
        if (root.left != null) dfs(root.left, lise);
        if (root.right != null) dfs(root.right, lise);
    }
}
