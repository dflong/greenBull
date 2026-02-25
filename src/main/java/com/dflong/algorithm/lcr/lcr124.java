package com.dflong.algorithm.lcr;

import com.sun.javafx.collections.MappingChange;

import java.util.HashMap;

public class lcr124 {

    public TreeNode deduceTree(int[] preorder, int[] inorder) {
        this.preOrder = preorder;
        this.inorder = inorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(0, preorder.length - 1);
    }

    int[] preOrder, inorder;
    int headIndex = 0;
    HashMap<Integer, Integer> map = new HashMap<>();

    TreeNode dfs(int l, int r) {
        if (l > r) return null;
        int headVal = preOrder[headIndex];
        headIndex ++;
        TreeNode root = new TreeNode(headVal);
        Integer inIdx = map.get(headVal);
        TreeNode left = dfs(l, inIdx - 1);
        TreeNode right = dfs(inIdx + 1, r);
        root.left = left;
        root.right = right;
        return root;
    }
}
