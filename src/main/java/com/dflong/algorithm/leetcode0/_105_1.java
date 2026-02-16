package com.dflong.algorithm.leetcode0;

import java.util.HashMap;
import java.util.Map;

public class _105_1 {

    int headIndex = 0;
    int[] preorder;
    int[] inorder;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(0, inorder.length - 1);
    }

    public TreeNode build(int l, int r) {
        if (l > r) {
            return null;
        }

        int val = preorder[headIndex ++];
        TreeNode root = new TreeNode(val);
        Integer integer = map.get(val);
        root.left = build(l, integer - 1);
        root.right = build(integer + 1, r);

        return root;
    }
}
