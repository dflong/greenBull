package com.dflong.algorithm.lcr;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class lcr048 {

    public static void main(String[] args) {
        Codec v = new Codec();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String serialize = v.serialize(root);
        TreeNode deserialize = v.deserialize(serialize);
    }

    public static class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            // 先序遍历
            dfs(root);
            return sb.toString();
        }

        StringBuilder sb = new StringBuilder();
        void dfs(TreeNode root) {
            if (root == null) {
                sb.append("#,");
                return;
            }

            sb.append(root.val).append(",");
            dfs(root.left);
            dfs(root.right);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            split = data.split(",");
            return dfs2();
        }

        int idx = 0;
        String[] split = null;
        public TreeNode dfs2() {
            if (split[idx].equals("#")) {
                idx ++;
                return null;
            }

            TreeNode root = new TreeNode(Integer.parseInt(split[idx]));
            idx ++;
            root.left = dfs2();
            root.right = dfs2();

            return root;
        }
    }
}
