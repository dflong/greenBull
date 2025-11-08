package com.dflong.greenbull.leetcode;

import java.util.LinkedList;
import java.util.List;

public class _95 {

    public static void main(String[] args) {
        new _95().generateTrees(3);
    }

    public List<TreeNode> generateTrees(int n) {
        return backTracking(1, n);
    }

    public List<TreeNode> backTracking(int L, int R) {
        List<TreeNode> res = new LinkedList<>();

        if (L > R) {
            res.add(null);
            return res;
        }

        for (int i = L; i <= R; i ++) {
            List<TreeNode> left = backTracking(L, i - 1);
            List<TreeNode> right = backTracking(i + 1, R);

            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }

        return res;
    }


}
