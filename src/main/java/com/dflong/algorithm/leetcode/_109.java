package com.dflong.algorithm.leetcode;

import java.util.List;

public class _109 {

    public static void main(String[] args) {
        ListNode head = new ListNode(- 10);
        head.next = new ListNode(- 3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);
        new _109().sortedListToBST(head);
    }

    public TreeNode sortedListToBST(ListNode head) {
        int len = getLen(head);
        this.head = head;
        return buildTree(0, len - 1);
    }

    ListNode head;

    public TreeNode buildTree(int L, int R) {
        if (L > R) return null;
        int m = (L + R) / 2;
        TreeNode left = buildTree(L, m - 1);
        TreeNode root = new TreeNode(head.val);
        head = head.next;
        root.left = left;
        root.right = buildTree(m + 1, R);

       return root;
    }

    public int getLen(ListNode root) {
        int len = 0;
        while (root != null) {
            root = root.next;
            len ++;
        }

        return len;
    }

    public TreeNode build(int L, int R, List<Integer> list) {
        if (L > R) return null;
        int m = (L + R) / 2;
        TreeNode root = new TreeNode(list.get(m));

        root.left = build(L, m - 1, list);
        root.right = build(m + 1, R, list);

        return root;
    }

}
