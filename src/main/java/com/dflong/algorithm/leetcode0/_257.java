package com.dflong.algorithm.leetcode0;

import java.util.ArrayList;
import java.util.List;

public class _257 {

    List<String> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size() - 1; i++) {
                sb.append(path.get(i)).append("->");
            }
            sb.append(path.get(path.size() - 1));
            res.add(sb.toString());
            return;
        }
        if (root.left != null) {
            dfs(root.left);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            dfs(root.right);
            path.remove(path.size() - 1);
        }
    }

}
