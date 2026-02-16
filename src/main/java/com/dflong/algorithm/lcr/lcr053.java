package com.dflong.algorithm.lcr;

public class lcr053 {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode res = null;
        // 中序遍历 如果有右节点，则找右节点的最左节点
        if (p.right != null) {
            res = p.right;
            while (res.left != null) {
                res = res.left;
            }

            return res;
        }
        // 没有就从头找
        TreeNode temp = root;
        while (temp != null) {
            if (temp.val > p.val) { // 继续往左找
                res = temp;
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }

        return res;
    }


}
