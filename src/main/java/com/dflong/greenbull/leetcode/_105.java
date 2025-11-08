package com.dflong.greenbull.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _105 {

    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int preBegin, int preEnd,
                          int[] inorder, int inBegin, int inEnd) {
        if (preBegin > preEnd || inBegin > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preBegin]);
        int inMid = map.get(preorder[preBegin]);
        // 确定左子树长度
        int inLeft = inMid - inBegin - 1;

        root.left = build(preorder, preBegin + 1, preBegin + inLeft + 1,
                inorder, inBegin, inMid - 1);
        root.right = build(preorder, preBegin + inLeft + 2, preEnd, inorder, inMid + 1, inEnd);
        return root;
    }


//    HashMap<Integer, Integer> map = new HashMap<>();
//    int headIndex = 0;
//    int[] preorder;
//    int[] inorder;
//
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        for (int i = 0; i < inorder.length; i++) {
//            map.put(inorder[i], i);
//        }
//        this.preorder = preorder;
//        this.inorder = inorder;
//
//        return buildTree(0, inorder.length - 1);
//    }
//
//    public TreeNode buildTree(int inLeft, int inRight) {
//        if (inLeft > inRight) {
//            return null;
//        }
//
//        int val = preorder[headIndex];
//        TreeNode root = new TreeNode(val);
//        Integer inHeadIndex = map.get(val);
//
//        headIndex ++;
//        root.left = buildTree(inLeft, inHeadIndex - 1);
//        root.right = buildTree(inHeadIndex + 1, inRight);
//
//        return root;
//    }
}
