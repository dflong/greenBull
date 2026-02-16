package com.dflong.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        midOrder(root);
        return res;
    }

    List<Integer> res = new ArrayList<>();

    // 1.参数、返回值
    public void midOrder(TreeNode root) {
        // 2.终止条件
        if (root == null) return;

        // 3.单层代码
        midOrder(root.left);
        res.add(root.val);
        midOrder(root.right);
    }

    // 左中右
    public void midOrder1(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            if (p != null) { // 一直到最左
                stack.push(p);
                p = p.left;
            } else { // 弹出左、中，之后压入右节点
                TreeNode pop = stack.pop();
                res.add(pop.val);
                p = pop.right;
            }
        }
    }
}
