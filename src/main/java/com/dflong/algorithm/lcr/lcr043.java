package com.dflong.algorithm.lcr;

import com.dflong.algorithm.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class lcr043 {
}


class CBTInserter {

    Queue<TreeNode> q = new LinkedList<TreeNode>();

    TreeNode root;

    public CBTInserter(TreeNode root) {
        this.root = root;

        // 完全二叉树，除倒数第二层和倒数第一层可能节点是不满的，其他全满
        // 寻找不满的节点，新插入的节点插入到不满的节点，满后移除

        Queue<TreeNode> temp = new LinkedList<>();
        temp.add(root);

        while (!temp.isEmpty()) {
            TreeNode node = temp.poll();
            if (node.left != null) {
                temp.add(node.left);
            }
            if(node.right != null) {
                temp.add(node.right);
            }

            if (node.left == null || node.right == null) {
                q.add(node);
            }
        }
    }

    public int insert(int v) {
        TreeNode newNode = new TreeNode(v);
        TreeNode peek = q.peek(); // q里的节点一定是不满的
        if (peek.left == null) {
            peek.left = newNode;
        } else {
            // 左节点有值
            peek.right = newNode;
            q.poll();
        }
        q.add(newNode);

        return peek.val;
    }

    public TreeNode get_root() {
        return root;
    }
}