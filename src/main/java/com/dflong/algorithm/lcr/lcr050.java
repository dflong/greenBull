package com.dflong.algorithm.lcr;

public class lcr050 {

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        this.targetSum = targetSum;
        dfs(root, 0);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return res;
    }

    int targetSum, res = 0;

    public void dfs(TreeNode root, long sum) {
        if (root == null) return;
        if (sum + root.val == targetSum) {
            res ++;
        }
        dfs(root.left, sum + root.val);
        dfs(root.right, sum + root.val);
    }
}
