package com.dflong.algorithm.leetcode0;

import java.util.ArrayList;
import java.util.List;

public class BSTIterator {

    List<Integer> list = null;
    int size = 0;
    int index = 0;

    public BSTIterator(TreeNode1 root) {
        list = new ArrayList<>();
        midOrder(root);
    }

    public int next() {
        return list.get(index++);
    }

    public boolean hasNext() {
        return index < size;
    }

    public void midOrder(TreeNode1 root) {
        if (root == null) return;

        midOrder(root.left);
        list.add(root.val);
        size ++;
        midOrder(root.right);
    }
}
