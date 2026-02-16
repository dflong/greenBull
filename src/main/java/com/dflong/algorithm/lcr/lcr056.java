package com.dflong.algorithm.lcr;

import java.util.HashSet;
import java.util.Set;

public class lcr056 {

    Set<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        boolean l = findTarget(root.left, k);
        if (set.contains(k - root.val)) return true;
        set.add(root.val);
        boolean r = findTarget(root.right, k);

        return l || r;
    }


}
