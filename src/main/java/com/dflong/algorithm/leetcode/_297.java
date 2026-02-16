package com.dflong.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _297 {

    public static void main(String[] args) {
        _297 v = new _297();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String serialize = v.serialize(root);
        TreeNode deserialize = v.deserialize(serialize);
    }

    // 先序遍历
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;
        String[] split = data.split(",");
        List<String> list = new ArrayList<>(Arrays.asList(split));
        return dfs2(list);
    }

    public TreeNode dfs2(List<String> list) {
        if (list.get(0).equals("NONE")) {
            list.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);
        root.left = dfs2(list);
        root.right = dfs2(list);

        return root;
    }

    public void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("NONE,");
            return;
        }

        sb.append(root.val + ",");
        dfs(root.left, sb);
        dfs(root.right, sb);
    }
}
