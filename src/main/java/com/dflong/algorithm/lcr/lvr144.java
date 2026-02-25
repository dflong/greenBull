package com.dflong.algorithm.lcr;

public class lvr144 {

    public TreeNode flipTree(TreeNode root) {
        if (root == null) return null;

        TreeNode L = flipTree(root.left);
        TreeNode R = flipTree(root.right);

        root.left = R;
        root.right = L;
        return root;
    }
}
