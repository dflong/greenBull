package com.dflong.greenbull.leetcode0;

import java.util.HashMap;
import java.util.Map;

public class _106 {

    int[] inorder;
    int[] postorder;
    Map<Integer, Integer> map = new HashMap<>();
    int headIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        this.headIndex = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(0, inorder.length - 1);
    }

    public TreeNode buildTree(int inorderLeft, int inorderRight) {
        if (inorderLeft > inorderRight) return null;
        int val = postorder[headIndex];
        TreeNode root = new TreeNode(val);
        headIndex --;
        Integer inIndex = map.get(val);
        root.right = buildTree(inIndex + 1, inorderRight);
        root.left = buildTree(inorderLeft, inIndex - 1);

        return root;
    }
}
