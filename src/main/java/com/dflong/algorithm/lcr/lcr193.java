package com.dflong.algorithm.lcr;

public class lcr193 {

    // 两个节点的最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return res;
    }

    TreeNode res;
    boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false; // 到底了

        boolean l = dfs(root.left, p, q);
        boolean r = dfs(root.right, p, q);

        if ((l && r) || ((l || r) && (root == p || root == q))) {
            res = root;
        }

        return l || r || root == p || root == q;
    }
}
