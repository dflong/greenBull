package com.dflong.greenbull.leetcode0;

import java.util.ArrayList;
import java.util.List;

public class _662 {

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        List<Pair2> list = new ArrayList<>();
        list.add(new Pair2(1, root));

        int max = 0;
        while (!list.isEmpty()) {
            List<Pair2> temp = new ArrayList<>();
            for (Pair2 pair : list) {
                if (pair.root.left != null) {
                    temp.add(new Pair2(pair.index * 2, pair.root.left));
                }
                if (pair.root.right != null) {
                    temp.add(new Pair2(pair.index * 2 + 1, pair.root.right));
                }
            }
            max = Math.max(max, list.get(list.size() - 1).index - list.get(0).index + 1);
            list = temp;
        }
        return max;
    }
}

class Pair2 {
    int index;
    TreeNode root;

    public Pair2(int index, TreeNode root) {
        this.index = index;
        this.root = root;
    }

    public Pair2() {
    }
}
