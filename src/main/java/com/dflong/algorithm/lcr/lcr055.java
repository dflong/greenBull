package com.dflong.algorithm.lcr;

public class lcr055 {

    class BSTIterator {
        // 中序遍历改成单向链表
        TreeNode pre = new TreeNode(), cur = pre;

        public BSTIterator(TreeNode root) {
            dfs(root);
        }

        void dfs(TreeNode root) {
            if (root == null) return;
            dfs(root.left);
            pre.right = root;
            root.left = null;
            pre = root;
            dfs(root.right);
        }

        public int next() {
            cur = cur.right;
            return cur.val;
        }

        public boolean hasNext() {
            return cur.right != null;
        }
    }
}
