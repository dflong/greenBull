package com.dflong.greenbull.leetcode0;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _94_95_144 {

    /**
     * 前序
     * @param root
     */
    public List<Integer> preOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return res;
    }

    /**
     * 中序
     * @param root
     */
    public List<Integer> inOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        TreeNode p = root;
        while (p.left != null) {
            stack.push(p.left);
            p = p.left;
        }

        while (!stack.isEmpty()) {
            p = stack.pop();
            res.add(p.val);

            if (p.right != null) {
                stack.push(p.right);
                p = p.right;
                while (p.left != null) {
                    stack.push(p.left);
                    p = p.left;
                }
            }
        }
        return res;
    }

    public List<Integer> inOrder1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();

        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                res.add(p.val);
                p = p.right;
            }
        }
        return res;
    }

    /**
     * 后序
     * @param root
     */
    public List<Integer> postOrder(TreeNode root) {
        List<Integer> res1 = new ArrayList<>();
        if (root == null) return res1;
        Stack<TreeNode> res = new Stack<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.push(node);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }

        while (!res.isEmpty()) {
            res1.add(res.pop().val);
        }

        return res1;
    }
}
