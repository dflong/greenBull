package com.dflong.greenbull.leetcode0;

public class _1379 {

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null) return null;
        if (original == target) return cloned;
        TreeNode targetCopy = getTargetCopy(original.left, cloned.left, target);
        if (targetCopy != null) return targetCopy;
        return getTargetCopy(original.right, cloned.right, target);
    }
}
