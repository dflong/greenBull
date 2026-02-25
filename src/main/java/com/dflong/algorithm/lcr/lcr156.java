package com.dflong.algorithm.lcr;

public class lcr156 {
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
