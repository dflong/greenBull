package com.dflong.greenbull.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class _145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        postOrder(root);
        return res;
    }

    List<Integer> res = new ArrayList<>();

    public void postOrder(TreeNode root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        res.add(root.val);
    }

    // 左右中
    public void postOrder1(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> pushStack = new Stack<>();
        pushStack.push(root);

        while (!pushStack.isEmpty()) {
            TreeNode pop = pushStack.pop();
            res.add(pop.val); // 中右左

            if (pop.left != null) pushStack.push(pop.left);
            if (pop.right != null) pushStack.push(pop.right);
        }

        Collections.reverse(res);
    }
}
