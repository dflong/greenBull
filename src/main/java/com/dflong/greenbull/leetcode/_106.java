package com.dflong.greenbull.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _106 {

    public static void main(String[] args) {
        new _106().buildTree(new int[] {9, 3, 15, 20, 7}, new int[] {9, 15, 7 , 20, 3});
    }

    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    public TreeNode build(int[] inorder, int inBegin, int inEnd,
                          int[] postorder, int postBegin, int postEnd) {
        if (inBegin > inEnd || postBegin > postEnd) return null;

        TreeNode root = new TreeNode(postorder[postEnd]);
        int inMid = map.get(postorder[postEnd]);
        // 确定左子树的长度
        int leftLen = inMid - inBegin - 1;

        root.left = build(inorder, inBegin, inMid - 1,
                postorder, postBegin, postBegin + leftLen);
        root.right = build(inorder, inMid + 1, inEnd,
                postorder, postBegin + leftLen + 1, postEnd - 1);

        return root;
    }



//    int[] inorder;
//    int[] postorder;
//    Map<Integer, Integer> map = new HashMap<>();
//    int headIndex;
//
//    public TreeNode buildTree(int[] inorder, int[] postorder) {
//        this.inorder = inorder;
//        this.postorder = postorder;
//        this.headIndex = postorder.length - 1;
//        for (int i = 0; i < inorder.length; i++) {
//            map.put(inorder[i], i);
//        }
//        return buildTree(0, inorder.length - 1);
//    }
//
//    public TreeNode buildTree(int inorderLeft, int inorderRight) {
//        if (inorderLeft > inorderRight) return null;
//        int val = postorder[headIndex];
//        TreeNode root = new TreeNode(val);
//        headIndex --;
//        Integer inIndex = map.get(val);
//        root.right = buildTree(inIndex + 1, inorderRight);
//        root.left = buildTree(inorderLeft, inIndex - 1);
//
//        return root;
//    }
}