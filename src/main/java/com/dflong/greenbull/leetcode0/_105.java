package com.dflong.greenbull.leetcode0;

import java.util.HashMap;

public class _105 {

    HashMap<Integer, Integer> map = new HashMap<>();
    int headIndex = 0;
    int[] preorder;
    int[] inorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        this.preorder = preorder;
        this.inorder = inorder;

        return buildTree(0, inorder.length - 1);
    }

    public TreeNode buildTree(int inLeft, int inRight) {
        if (inLeft > inRight) {
            return null;
        }

        int val = preorder[headIndex];
        TreeNode root = new TreeNode(val);
        Integer inHeadIndex = map.get(val);

        headIndex ++;
        root.left = buildTree(inLeft, inHeadIndex - 1);
        root.right = buildTree(inHeadIndex + 1, inRight);

        return root;
    }
}
