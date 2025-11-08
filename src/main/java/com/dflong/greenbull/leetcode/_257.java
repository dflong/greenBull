package com.dflong.greenbull.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _257 {

    List<String> res = new ArrayList<String>();
    List<Integer> paths = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        paths.add(root.val);
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < paths.size() - 1; i++) {
                sb.append(paths.get(i)).append("->");
            }
            sb.append(paths.get(paths.size() - 1));
            res.add(sb.toString());
            return;
        }

        if (root.left != null) {
            dfs(root.left);
            paths.remove(paths.size() - 1);
        }
        if (root.right != null) {
            dfs(root.right);
            paths.remove(paths.size() - 1);
        }
    }
}
