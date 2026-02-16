package com.dflong.algorithm.leetcode0;

import java.util.ArrayList;
import java.util.List;

public class _1382 {

    public TreeNode balanceBST(TreeNode root) {
        // 中序遍历得到数组
        dfs(root);
        // 重建二叉树
        return build(0, list.size() - 1);
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }

    public TreeNode build(int l, int r) {
        if (l > r) return null;
        int m = (l + r) / 2;
        TreeNode root = new TreeNode(list.get(m));
        root.left = build(l, m - 1);
        root.right = build(m + 1, r);
        return root;
    }

    List<Integer> list = new ArrayList<>();
}
