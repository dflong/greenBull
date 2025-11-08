package com.dflong.greenbull.leetcode0;

public class _437 {

    public int pathSum(TreeNode root, int targetSum) {
       this.targetSum = targetSum;
       if (root == null) return 0;
       dfs(root, 0);
       pathSum(root.left, targetSum);
       pathSum(root.right, targetSum);
       return res;
    }

    int res = 0, targetSum;

    public void dfs(TreeNode root, long sum) {
        if (root == null) return;
        if (root.val + sum == targetSum) {
            res ++;
            return;
        }
        if (root.left != null) {
            dfs(root.left, sum + root.val);
        }
        if (root.right != null) {
            dfs(root.right, sum + root.val);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        root.right.right.right.right = new TreeNode(5);

        new _437().pathSum(root, 3);
    }
}
