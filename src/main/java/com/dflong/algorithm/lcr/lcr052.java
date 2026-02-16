package com.dflong.algorithm.lcr;

import java.util.ArrayList;
import java.util.List;

public class lcr052 {

    public TreeNode increasingBST(TreeNode root) {
        dfs(root);
        root = list.get(0);
        for (int i = 0; i < list.size() - 1; i ++) {
            list.get(i).right = list.get(i + 1);
            list.get(i).left = null;
        }
        list.get(list.size() - 1).left = null;
        list.get(list.size() - 1).right = null;
        return root;
    }

    List<TreeNode> list = new ArrayList<>();

    public void dfs(TreeNode treeNode) {
        if (treeNode == null) return;
        dfs(treeNode.left);
        list.add(treeNode);
        dfs(treeNode.right);
    }
}
