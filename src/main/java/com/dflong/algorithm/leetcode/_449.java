package com.dflong.algorithm.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _449 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preDfs(root, sb);
        return sb.toString();
    }

    public void preDfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#").append(",");
            return;
        }
        sb.append(root.val).append(",");
        preDfs(root.left, sb);
        preDfs(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(split));
        return dfs(list);
    }

    public TreeNode dfs(List<String> list) {
        if (list.get(0).equals("#")) {
            list.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);
        root.left = dfs(list);
        root.right = dfs(list);

        return root;
    }
}
