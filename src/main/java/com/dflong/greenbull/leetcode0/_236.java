package com.dflong.greenbull.leetcode0;

public class _236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return res;
    }

    TreeNode res = null;

    public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean l = dfs(root.left, p, q);
        boolean r = dfs(root.right, p, q);
        if ((l && r) || ((root == p || root == q) && (l || r))) {
            res = root;
        }

        return l || r || root == p || root == q;
    }


//    Map<TreeNode1, TreeNode1> map = new HashMap<>();
//    Set<TreeNode1> set = new HashSet<>();
//
//    public TreeNode1 lowestCommonAncestor(TreeNode1 root, TreeNode1 p, TreeNode1 q) {
//        getMap(root);
//        getSet(p);
//
//        while (q != null) {
//            if (set.contains(q)) {
//                return q;
//            }
//            q = map.get(q);
//        }
//
//        return root;
//    }
//
//    public void getMap(TreeNode1 root) {
//        if (root == null) return;
//
//        if (root.left != null) {
//            map.put(root.left, root);
//            getMap(root.left);
//        }
//
//        if (root.right != null) {
//            map.put(root.right, root);
//            getMap(root.right);
//        }
//    }
//
//    public void getSet(TreeNode1 p) {
//        while (p != null) {
//            set.add(p);
//            p = map.get(p);
//        }
//    }
}
