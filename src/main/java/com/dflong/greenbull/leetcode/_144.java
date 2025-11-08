package com.dflong.greenbull.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        preOrder(root);
        return res;
    }

    List<Integer> res = new ArrayList<>();

    // 1.参数和返回值
    public void preOrder(TreeNode root) {
        // 2.终止条件
        if (root == null) return;

        res.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    // 非递归方式
    public void preOrder1(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            res.add(pop.val);
            if (pop.right != null) stack.push(pop.right);
            if (pop.left != null) stack.push(pop.left);
        }
    }
}
