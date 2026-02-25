package com.dflong.algorithm.lcr;

public class lcr152 {

    public boolean verifyTreeOrder(int[] postorder) {
        if (postorder == null || postorder.length == 1) return true;
        // 构建二叉树，如果可以完整构造，return true
        end = postorder.length - 1;
        build(postorder, Integer.MAX_VALUE, Integer.MIN_VALUE);

        return end < 0;
    }

    int end;
    void build(int[] postOrder, int max, int min) {
        if (end < 0) return;
        int val = postOrder[end];
        if (val >= max || val <= min) return;
        end --;
        // 先右后左
        build(postOrder, max, val);
        build(postOrder, val, min);
    }
}
